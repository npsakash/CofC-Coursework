df = read.table('dataset.txt',sep="|",header=T)

# If you want to test on just 1000 records using df.1000 created below
idx.1000 = sample(1:nrow(df),1000)
df.1000 = df[idx.1000,]

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
