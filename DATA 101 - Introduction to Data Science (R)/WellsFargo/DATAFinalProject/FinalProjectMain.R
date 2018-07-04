# # # # # # # # # # # # # # # # # # # # #

## This program initializes the environment for the project.
##
## Taking the dataset as input, the data is chunked by its
##  content between the four banks, by its origin, and the
##  indicies are saved for use when examining each bank on
##  an individual basis.



# load functions
source("Functions.R")
source("OverallSentiment.R")
# required packages
reqPackages <- c("quanteda", "dplyr", "tm", "qdap")

# load/install packages
DynamicRequire(reqPackages)

# set myStopWords and remWords (list of terms to remove for text analysis)
myStopWords <- unlist(strsplit(readLines("myStopWords.txt"), split=", "))
remWords <- c("banka","bankb","bankc","bankd", "bank", myStopWords)

# generate a table of valence rated words on a scale from -5 to +5
valWords <- unlist(strsplit(readLines("valWords.txt"), split=", "))
valWordList <- read.delim(file = "ValWordTable.txt", header = FALSE, stringsAsFactors = FALSE)
names(valWordList) <- c("word", "score")

# generate tabular data.frame of dataset
dfTable <- read.table('dataset.txt',header=TRUE, sep="|", stringsAsFactors = FALSE)

# generate a data frame with "MediaType" and "FullText" fields from dataset
df <- dfTable[, c("AutoID","FullText")]
rm(dfTable)




#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#
#-#-#-#-#-#-#-#-#-#-#-#      BEGIN  CLEANSING  DATA     #-#-#-#-#-#-#-#-#-#-#-#
#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#


######################################################
# # Only essential/ globally necessary operations are
# # performed on the main dataframe (df). Row_names act
# # preserve $AutoID in order to reverse look-up
# # original texts later
######################################################

# remove non-ascii characters
dfTxt <- as.data.frame(iconv(df$FullText, "latin1", "ASCII", sub=""))
df$FullText <- dfTxt[, 1]
rm(dfTxt)

# remove unnecessary / unwanted characters
df$FullText <- gsub("[[:punct:]]", "", df$FullText, perl = TRUE)
df$FullText <- gsub("[[:digit:]]", "", df$FullText, perl = TRUE)
df$FullText <- gsub("[[:cntrl:]]", "", df$FullText, perl = TRUE)

# migrate all characters to lowerCase
df$FullText <- tolower(df$FullText)

# reduce whitespace and NULL records
df$FullText <- gsub("\\s+", " ", df$FullText, perl = TRUE)
df$FullText <- gsub("^\\s+|\\s+$", "", df$FullText, perl = TRUE)

# corect common spelling errors
df$FullText <- gsub("cancell", "cancel", df$FullText, perl = TRUE)

# BankE non-target data abstraction
df$FullText <- gsub("banke", "ally", df$FullText, perl = TRUE)
df$FullText <- gsub("automatibankc anke", "automatically", df$FullText, perl = TRUE)

# BankA non-target data abstraction
df$FullText <- gsub("hobanka ", "how f", df$FullText, perl = TRUE)
df$FullText <- gsub("nebanka ", "new f", df$FullText, perl = TRUE)
df$FullText <- gsub("rebanka ", "rew f", df$FullText, perl = TRUE)
df$FullText <- gsub("viebanka ", "view f", df$FullText, perl = TRUE)
df$FullText <- gsub("nobanka ", "now f", df$FullText, perl = TRUE)
df$FullText <- gsub("labanka ", "law f", df$FullText, perl = TRUE)
df$FullText <- gsub("follobanka ", "follow f", df$FullText, perl = TRUE)
df$FullText <- gsub("withdrabanka ", "withdraw f", df$FullText, perl = TRUE)
df$FullText <- gsub("abankaul", "awful", df$FullText, perl = TRUE)
df$FullText <- gsub("tomorrobanka ", "tomorrow f", df$FullText, perl = TRUE)

# BankD non-target data abstraction
df$FullText <- gsub("bankds", "chases", df$FullText, perl = TRUE)
df$FullText <- gsub("bankd asset", "asset", df$FullText, perl = TRUE)
df$FullText <- gsub("bankd mission main street", "mission main street", df$FullText, perl = TRUE)
df$FullText <- gsub("rating at bankd", "rating at", df$FullText, perl = TRUE)
df$FullText <- gsub("rating from bankd", "rating from", df$FullText, perl = TRUE)
df$FullText <- gsub("reiterated at bankd", "reiterated at", df$FullText, perl = TRUE)





######################################################
# # Split dataframe into subsets by bankname
######################################################

# GetRecords for each
dfBankA <- GetRecords(" banka ")
dfBankB <- GetRecords(" bankb ")
dfBankC <- GetRecords(" bankc ")
dfBankD <- GetRecords(" bankd ")

# # write .txt of dataframes to file
# write.table(dfBankA, file = "dfBankADirty.txt")
# write.table(dfBankB, file = "dfBankBDirty.txt")
# write.table(dfBankC, file = "dfBankCDirty.txt")
# write.table(dfBankD, file = "dfBankDDirty.txt")



# Clean the Records
# this function is the workhorse.
#  "View(CleanRecords)" to see the function
dfBankA <- CleanRecords(dfBankA)
dfBankB <- CleanRecords(dfBankB)
dfBankC <- CleanRecords(dfBankC)
dfBankD <- CleanRecords(dfBankD)

# # write .txt of dataframes to file
# write.table(dfBankA, file = "dfBankA.txt")
# write.table(dfBankB, file = "dfBankB.txt")
# write.table(dfBankC, file = "dfBankC.txt")
# write.table(dfBankD, file = "dfBankD.txt")




######################################################
# # Generate a Document Feature Matrix
# # the dfm can be converted to a Doc-Term-Matrix
# # compatitble with the tm-package with the command
# #    dtm <- convert(dfm, to = "tm")
######################################################

# GetFeaturedWords found in each
featWrdsBankA <- GetFeaturedWordList(dfBankA)
featWrdsBankB <- GetFeaturedWordList(dfBankB)
featWrdsBankC <- GetFeaturedWordList(dfBankC)
featWrdsBankD <- GetFeaturedWordList(dfBankD)

# GetFeaturedWordFreq for each
featWrdFreqBankA <- GetFeatWordFreq(dfBankA)
featWrdFreqBankB <- GetFeatWordFreq(dfBankB)
featWrdFreqBankC <- GetFeatWordFreq(dfBankC)
featWrdFreqBankD <- GetFeatWordFreq(dfBankD)





######################################################
# # Calculate Overall Sentiment (20 - 30 mins for all)
# # uses all terms usually around 1700 per abnk
######################################################
# ovrAllSentA <- OverallSentiment(featWrdsBankA, dfBankA)
# ovrAllSentB <- OverallSeOverallSentimentnt500(featWrdsBankB, dfBankB)
# ovrAllSentC <- OverallSeOverallSentimentnt500(featWrdsBankC, dfBankC)
# ovrAllSentD <- OverallSOverallSentimentent500(featWrdsBankD, dfBankD)


###########################################
# Abbreviated Overall Sentiment (4 - 6 mins for all)
#  uses top 200 terms by freq. If this is
# running to long..."View(OverallSent100)"
#  to change the number of terms to consider
###########################################
strt<-Sys.time()
ovrAllSentA <- OverallSent500(featWrdsBankA, dfBankA)
print(Sys.time()-strt)

strt<-Sys.time()
ovrAllSentB <- OverallSent500(featWrdsBankB, dfBankB)
print(Sys.time()-strt)

strt<-Sys.time()
ovrAllSentC <- OverallSent500(featWrdsBankC, dfBankC)
print(Sys.time()-strt)

strt<-Sys.time()
ovrAllSentD <- OverallSent500(featWrdsBankD, dfBankD)
print(Sys.time()-strt)





######################################################
# # Generate Bigrams and Trigrams
# # another lengthy process. around 15 mins total
# # Bi-Trigrams are used to generate wordclouds and
# # other bank specific data mining
######################################################

# GetTrigrams for each
triGramBankA <- GetTrigrams(dfBankA)
triGramBankB <- GetTrigrams(dfBankB)
triGramBankC <- GetTrigrams(dfBankC)
triGramBankD <- GetTrigrams(dfBankD)

# GetBigrams for each
biGramBankA <- GetBigrams(dfBankA)
biGramBankB <- GetBigrams(dfBankB)
biGramBankC <- GetBigrams(dfBankC)
biGramBankD <- GetBigrams(dfBankD)

# Get Trigrams that contain at least one ValWord
triGramBankA2 <- GetValWordTrigrams(dfBankA)
triGramBankB2 <- GetValWordTrigrams(dfBankB)
triGramBankC2 <- GetValWordTrigrams(dfBankC)
triGramBankD2 <- GetValWordTrigrams(dfBankD)

# Get Bigrams that contain at least one ValWord
biGramBankA2 <- GetValWordBigrams(dfBankA)
biGramBankB2 <- GetValWordBigrams(dfBankB)
biGramBankC2 <- GetValWordBigrams(dfBankC)
biGramBankD2 <- GetValWordBigrams(dfBankD)

# write .txt of dataframes to file
write.table(dfBankA, file = "dfBankA.txt")
write.table(dfBankB, file = "dfBankB.txt")
write.table(dfBankC, file = "dfBankC.txt")
write.table(dfBankD, file = "dfBankD.txt")


