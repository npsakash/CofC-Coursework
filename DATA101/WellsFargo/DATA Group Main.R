
dynamicRequire <- function(reqPackages){
  # Accepts a character vector populated with user 
  #  defined packages. For each package: 
  #   load package if previously installed
  #   OR
  #   install package
  #
  # Args:
  #  reqPackages: a character vector containing package names
  # # # # # # # # # # # # # # # # # # # # #
  for(pkg in reqPackages ){
    if(!require(pkg, character.only = TRUE)){
      install.packages(pkg, dependencies = TRUE)  
      require(pkg, quietly = TRUE, character.only = TRUE) 
    }
  }
}


# required packages
reqPackages <- c("plyr", "tm", "quanteda", "stringr", "ggplot2",
                 "lsa","NLP", "openNLP", "SnowballC", "lsa", "tau",
                 "RColorBrewer", "wordcloud")

# load/install packages
dynamicRequire(reqPackages)




# set myStopWords
myStopWords <- as.character(read.csv("myStopWords.txt", header = FALSE, 
                                     stringsAsFactors = FALSE))

# generate AFINN-111 data frame containing valence rated
#  rated words on a scale from -5 to +5
afinnTerms <- read.delim(file = "AFINN-111.txt", header = FALSE,
                         stringsAsFactors = FALSE)
names(afinnTerms) <- c("word", "score")

# adding dictionary with 450 stopwords and case specific
myDict <- dictionary(afinnTerms)




# generate a tabular representation of dataset
dfTable <- read.table('dataset.txt',header=TRUE, sep="|", stringsAsFactors = FALSE)

# generate a data frame with "MediaType" and "FullText" fields from dataset
dfTxtAndSrc <- dfTable[, c("MediaType","FullText")]

# generate a data frame with only "FullText" field from dataset
dfTxts <- dfTxtAndSrc["FullText"]



# find and remove all NULL records
dfTxts$FullText[dfTxts$FullText==""] <- NA
dfTxtAndSrc$FullText[dfTxts$FullText==""] <- NA
dfTxts <- na.omit(dfTxts)
dfTxtAndSrc <- na.omit(dfTxts)

# remove non-ascii characters
dfTxts <- as.data.frame(iconv(dfTxts$FullText, "latin1", "ASCII", sub=""))
colnames(dfTxts) = 'FullText'

# remove unnecessary characters 
dfTxts$FullText <- gsub("[[:punct:]]", "", dfTxts$FullText, perl = TRUE)
dfTxts$FullText <- gsub("[[:digit:]]", "", dfTxts$FullText, perl = TRUE)
dfTxts$FullText <- gsub("[[:cntrl:]]", "", dfTxts$FullText, perl = TRUE)

# all characters lowerCase
dfTxts$FullText <- tolower(dfTxts$FullText)



# generate indexes of mention per bank
indBankA = which(sapply(dfTxts$FullText,function(x) grepl("banka",x)))
indBankB = which(sapply(dfTxts$FullText,function(x) grepl("bankb",x)))
indBankC = which(sapply(dfTxts$FullText,function(x) grepl("bankc",x)))
indBankD = which(sapply(dfTxts$FullText,function(x) grepl("bankd",x)))


# indicies of banka mentions and use to 
# create a character vector
indBankA = which(sapply(dfTxts$FullText,function(x) grepl("banka",x)))
charBankA = dfTxts[indBankA, ]

# generate a Corpus from the character vector
corpA <- corpus(charBankA)
summary(corpA)

# might need this later
dfBankA <- as.data.frame(charBankA)




# attempt to generate tokens from the remaining dataset 
txtA <- c("twithndlbanka choose a checking account banking managing spending banka makes easy manage banking.")
tokenize(txtA)

# Create a Document-Frequency Matrix(dfm) using Corpus
dfmBankA <- dfm(corpA, ignoredFeatures = c(stopwords("english")))

# generate a WordCould from dfm 
plot(dfmBankA, max.words=100, random.order=FALSE, colors = brewer.pal(8, "Dark2"), scale=c(5, .5))

# Add irrelevant words to the ignoredFeatures parameter
dfmBankA <- dfm(corpA, ignoredFeatures = c("twithndlbanka", "name", "banka","twithndl",
                                           "internet","rettwit", "bank", "bankb",
                                           stopwords("english")))

# generate a WordCould from new dfm 
plot(dfmBankA, max.words=200, random.order=FALSE, colors = brewer.pal(8, "Dark2"), scale=c(4, .25))



