library(twitteR)
df = read.table('dataset.txt',sep="|",header=T)

# If you want to test on just 1000 records using df.subset created below
idx.1000 = sample(1:nrow(df),1000)
df.subset = df[idx.1000,]

# Grab just the texts, so you can load them in the Corpus
df.texts = as.data.frame(df[,ncol(df)])
colnames(df.texts) = 'FullText'

# Remove non-ascii characters
df.texts.clean = as.data.frame(iconv(df.texts$FullText, "latin1", "ASCII", sub=""))
colnames(df.texts.clean) = 'FullText'

# Load using the tm library
library(tm) 
docs <- Corpus(DataframeSource(df.texts.clean))   

# Strip extra whitespace
docs <- tm_map(docs, stripWhitespace)

bankA.idx = which(sapply(df$FullText,function(x) grepl("BankA",x)))
bankB.idx = which(sapply(df$FullText,function(x) grepl("BankB",x)))
bankC.idx = which(sapply(df$FullText,function(x) grepl("BankC",x)))
bankD.idx = which(sapply(df$FullText,function(x) grepl("BankD",x)))

# This turns out to be too slow
# Add the metadata
# This takes a bit to run
# You can add more here
#for (i in 1:nrow(df)) {
#  meta(docs[[i]],"MediaType") = df$MediaType[i]
#  meta(docs[[i]],"Year") = df$Year[i]
#  if (grepl("BankA",df$FullText[i])) {
#    meta(docs[[i]],"BankA") = T
#  } else {
#    meta(docs[[i]],"BankA") = F
#  }
#  if (grepl("BankB",df$FullText[i])) {
#    meta(docs[[i]],"BankB") = T
#  } else {
#    meta(docs[[i]],"BankB") = F
#  }
#}
#bankA.idx <- meta(docs, "BankA") == T

bankA.docs = docs[bankA.idx]
bankB.docs = docs[bankB.idx]
bankC.docs = docs[bankC.idx]
bankD.docs = docs[bankD.idx]

summary(docs)

docs <- tm_map(docs, removePunctuation) 

# Since we can't find a great package in R, I'm going to use an
# example I found online to build our own
# Based on: http://www.ihub.co.ke/blogs/23216

# Only need to do once
# Download and upload: http://www.cs.uic.edu/~liub/FBS/opinion-lexicon-English.rar
#system('unrar e opinion-lexicon-English.rar')

pos <- scan('positive-words.txt',what='character',comment.char=';')
neg <- scan('negative-words.txt',what='character',comment.char=';')

score.sentiment = function(sentences, pos.words, neg.words, .progress='none')
{
  require(plyr)
  require(stringr)
  
  # we got a vector of sentences. plyr will handle a list
  # or a vector as an "l" for us
  # we want a simple array ("a") of scores back, so we use 
  # "l" + "a" + "ply" = "laply":
  scores = laply(sentences, function(sentence, pos.words, neg.words) {
    
    # clean up sentences with R's regex-driven global substitute, gsub():
    sentence = gsub('[[:punct:]]', '', sentence)
    sentence = gsub('[[:cntrl:]]', '', sentence)
    sentence = gsub('\\d+', '', sentence)
    # and convert to lower case:
    sentence = tolower(sentence)
    
    # split into words. str_split is in the stringr package
    word.list = str_split(sentence, '\\s+')
    # sometimes a list() is one level of hierarchy too much
    words = unlist(word.list)
    
    # compare our words to the dictionaries of positive & negative terms
    pos.matches = match(words, pos.words)
    neg.matches = match(words, neg.words)
    
    # match() returns the position of the matched term or NA
    # we just want a TRUE/FALSE:
    pos.matches = !is.na(pos.matches)
    neg.matches = !is.na(neg.matches)
    
    # and conveniently enough, TRUE/FALSE will be treated as 1/0 by sum():
    score = sum(pos.matches) - sum(neg.matches)
    
    return(score)
  }, pos.words, neg.words, .progress=.progress )
  
  scores.df = data.frame(score=scores, text=sentences)
  return(scores.df)
}

df.subset = df[bankB.idx,]

scores = score.sentiment(df.subset$FullText, pos, neg, .progress='text')
scores$very.pos = as.numeric(scores$score >= 2)
scores$very.neg = as.numeric(scores$score <= -2)

# how many very positives and very negatives
numpos = sum(scores$very.pos)
numneg = sum(scores$very.neg)

# global score
global_score = round( 100 * numpos / (numpos + numneg) )

scores$mediatype = df.subset$MediaType

# colors
cols = c("#7CAE00", "#00BFC4")
names(cols) = c("twitter", "facebook")

# boxplot
library(ggplot2)
ggplot(scores, aes(x=mediatype, y=score, group=mediatype)) +
  geom_boxplot(aes(fill=mediatype)) +
  scale_fill_manual(values=cols) +
  geom_jitter(colour="gray40",position=position_jitter(width=0.2), alpha=0.3) +
  labs(title = "BankB Media Type's Sentiment Scores") + 
  xlab('Media Type') + ylab('Sentiment Score')

# barplot of average score
meanscore = tapply(scores$score, scores$mediatype, mean)
df.plot = data.frame(mediatype=names(meanscore), meanscore=meanscore)
df.plot$mediatypes <- reorder(df.plot$mediatype, df.plot$meanscore)

ggplot(df.plot, aes(x = factor(mediatypes), y = meanscore, fill=mediatypes)) +
  geom_bar(stat="identity") +
  scale_fill_manual(values=cols[order(df.plot$meanscore)]) +
  labs(title = "BankB Average Sentiment Score") + 
  xlab('Media Type') + ylab('Average Score')

# barplot of average very positive
mediatype_pos = ddply(scores, .(mediatype), summarise, mean_pos=mean(very.pos))
mediatype_pos$mediatypes <- reorder(mediatype_pos$mediatype, mediatype_pos$mean_pos)

ggplot(mediatype_pos, aes(x = factor(mediatypes), y = meanscore, fill=mediatypes)) +
  geom_bar(stat="identity") +
  scale_fill_manual(values=cols[order(df.plot$meanscore)]) +
  labs(title = "BankB Average Very Positive Sentiment Score") + 
  xlab('Media Type') + ylab('Average Score')

mediatype_neg = ddply(scores, .(mediatype), summarise, mean_pos=mean(very.neg))
mediatype_neg$mediatypes <- reorder(mediatype_pos$mediatype, mediatype_pos$mean_pos)

ggplot(mediatype_pos, aes(x = factor(mediatypes), y = meanscore, fill=mediatypes)) +
  geom_bar(stat="identity") +
  scale_fill_manual(values=cols[order(df.plot$meanscore)]) +
  labs(title = "Bank BAverage Very Negative Sentiment Score") + 
  xlab('Media Type') + ylab('Average Score')

findAssocs(dtm, ("bankb"), corlimit=0.01)
