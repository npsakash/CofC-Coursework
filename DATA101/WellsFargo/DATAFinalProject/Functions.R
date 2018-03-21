# Functions.R

DynamicRequire <- function(reqPackages){
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


GetRecords <- function(bankName){
  # Accepts
  #
  # Args:
  #
  # # # # # # # # # # # # # # # # # # # # #

  # retrieve texts for specified bank
  dfTemp <- df
  dfTemp <- df[which(sapply(df$FullText,function(x) grepl(bankName, x))), ]
  return (dfTemp)
}

CleanRecords <- function(dfBankName){
  # Accepts
  #
  # Args:
  #
  # # # # # # # # # # # # # # # # # # # # #

  # retrieve texts for specified bank
  dfBnk <- dfBankName
  dfBnk$FullText <- as.data.frame(removeWords(dfBnk$FullText, remWords),
                                  stringsAsFactors = FALSE)
  colnames(dfBnk[, 2]) <- "FullText"

  # eliminate whitespace from deletions
  dfBnk$FullText <- gsub("\\s+", " ", dfBnk$FullText, perl = TRUE)

  # reduce repeated words (do this twice)
  dfBnk$FullText <- gsub("\\b(\\w+.+)\\s+\\1\\b", "\\1", dfBnk$FullText, perl = TRUE)
  dfBnk$FullText <- gsub("\\b(\\w+.+)\\s+\\1\\b", "\\1", dfBnk$FullText, perl = TRUE)

  # concatenate common dual-words into single term
  dfBnk$FullText <- gsub("customer service", "customer_service", dfBnk$FullText, perl = TRUE)
  dfBnk$FullText <- gsub("customer support", "customer_service", dfBnk$FullText, perl = TRUE)
  dfBnk$FullText <- gsub("checking account", "checking_account", dfBnk$FullText, perl = TRUE)
  dfBnk$FullText <- gsub("check account", "checking_account", dfBnk$FullText, perl = TRUE)
  dfBnk$FullText <- gsub("savings account", "savings_account", dfBnk$FullText, perl = TRUE)
  dfBnk$FullText <- gsub("car loan", "car_loan", dfBnk$FullText, perl = TRUE)
  dfBnk$FullText <- gsub("credit card", "credit_card", dfBnk$FullText, perl = TRUE)
  dfBnk$FullText <- gsub("debit card", "debit_card", dfBnk$FullText, perl = TRUE)
  dfBnk$FullText <- gsub("asset management", "asset_management", dfBnk$FullText, perl = TRUE)
  dfBnk$FullText <- gsub("thank you", "thank_you", dfBnk$FullText, perl = TRUE)
  dfBnk$FullText <- gsub("i \\w+ hate", "i_hate", dfBnk$FullText, perl = TRUE)

  # eliminate space at begin and end of texts
  dfBnk$FullText <- gsub("^\\s+|\\s+$", "", dfBnk$FullText, perl = TRUE)

  # eliminate texts with less than three words
  dfBnk$FullText <- gsub("\\A(\\b\\w+\\s*){1,3}\\Z", "", dfBnk$FullText, perl = TRUE)

  # eliminate NULL/NA records
  dfBnk$FullText <- gsub("^\\s+|\\s+$", "", dfBnk$FullText, perl = TRUE)
  dfBnk$FullText[dfBnk$FullText==""] <- NA
  dfBnk <- na.omit(dfBnk)
  return(dfBnk)
}




GetFeaturedWordList <- function(dfBankName){
  # Accepts
  #
  # Args:
  #
  # # # # # # # # # # # # # # # # # # # # #

  # generate a document feature matrix
  docFeatMatrix <- dfm(dfBankName[, 2],keptFeatures = valWords,concatenator = " ")

  # convert the dfm to a matrix, grab the original line numbers
  featAdjMatrix <- as.matrix(docFeatMatrix)
  rownames(featAdjMatrix) <- dfBankName$AutoID
  docFeatList <- features(docFeatMatrix)
  return (docFeatList)
}

GetFeatWordFreq <- function(dfBnk){
  # Accepts
  #
  # Args:
  #
  # # # # # # # # # # # # # # # # # # # # #

  #
  # retrieve texts for specified bank
  charVector <- as.character(dfBnk$FullText)


  # create unstemmed, skip-bigrams of ValWords
  dfmValWrd <- dfm(charVector,
                   verbose = TRUE,
                   keptFeatures = valWords,
                   concatenator = " ",
                   stem = FALSE)


  dfValWrd <- as.data.frame(topfeatures(dfmValWrd, n = 500))
  colnames(dfValWrd) <- "Freq"
  rName <- row.names(dfValWrd)
  dfValWrd$ValWrd <- rName
  row.names(dfValWrd) <- c(1:500)

  return(dfValWrd)
}




GetCharVector <- function(dfBankName){
  # Accepts
  #
  # Args:
  #
  # # # # # # # # # # # # # # # # # # # # #

  # retrieve texts for specified bank
  dfBnkTxtClean <- dfBankName
  dfBnkTxtClean$FullText <- as.data.frame(removeWords(dfBankName$FullText, remWords),
                                          stringsAsFactors = FALSE)
  charVector <- as.character(dfBnkTxtClean$FullText)
  return(charVector)
}

GetTrigrams <- function(dfBnk){
  # Accepts
  #
  # Args:
  #
  # # # # # # # # # # # # # # # # # # # # #

  charVector <- as.character(dfBnk$FullText)

  # create unstemmed, skip-trigrams
  dfmSgram <- dfm(charVector,
                  ngrams = 3,
                  skip = 0:2,
                  concatenator = " ",
                  stem=FALSE)

  dfSgram <- as.data.frame(topfeatures(dfmSgram, n = 500))
  colnames(dfSgram) <- "Freq"
  rName <- row.names(dfSgram)
  dfSgram$sGram <- rName
  row.names(dfSgram) <- c(1:500)

  return(dfSgram)

}



GetBigrams <- function(dfBnk){
  # Accepts
  #
  # Args:
  #
  # # # # # # # # # # # # # # # # # # # # #

  # retrieve texts for specified bank
  charVector <- as.character(dfBnk$FullText)

  # create unstemmed, skip-trigrams
  dfmSgram <- dfm(charVector,
                  ngrams = 2,
                  skip = 0:2,
                  concatenator = " ",
                  stem=FALSE)

  dfSgram <- as.data.frame(topfeatures(dfmSgram, n = 500))
  colnames(dfSgram) <- "Freq"
  rName <- row.names(dfSgram)
  dfSgram$sGram <- rName
  row.names(dfSgram) <- c(1:500)

  return(dfSgram)

}




GetValWordTrigrams <- function(dfBnk){
  # Accepts
  #
  # Args:
  #
  # # # # # # # # # # # # # # # # # # # # #

  charVector <- as.character(dfBnk$FullText)

  # create unstemmed, skip-trigrams
  dfmSgram <- dfm(charVector,
                  ngrams = 3,
                  skip = 0:1,
                  concatenator = " ",
                  keptFeatures = valWords,
                  stem=TRUE)

  dfSgram <- as.data.frame(topfeatures(dfmSgram, n = 500))
  colnames(dfSgram) <- "Freq"
  rName <- row.names(dfSgram)
  dfSgram$sGram <- rName
  row.names(dfSgram) <- c(1:500)

  return(dfSgram)

}



GetValWordBigrams <- function(dfBnk){
  # Accepts
  #
  # Args:
  #
  # # # # # # # # # # # # # # # # # # # # #

  # retrieve texts for specified bank
  charVector <- as.character(dfBnk$FullText)

  # create unstemmed, skip-trigrams
  dfmSgram <- dfm(charVector,
                  ngrams = 2,
                  skip = 0:1,
                  concatenator = " ",
                  keptFeatures = valWords,
                  stem=TRUE)

  dfSgram <- as.data.frame(topfeatures(dfmSgram, n = 500))
  colnames(dfSgram) <- "Freq"
  rName <- row.names(dfSgram)
  dfSgram$sGram <- rName
  row.names(dfSgram) <- c(1:500)

  return(dfSgram)

}














