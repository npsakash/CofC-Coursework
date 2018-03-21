
OverallSentiment <- function(ftWrdBnk, dfBnk) {
  #import packages
  library(foreach)
  library(doParallel)

  #setup parallel backend to use 8 processors
  cl<-makeCluster(8)
  registerDoParallel(cl)

  # featWrdsBankName contains all valWords found in texts
  #  aliases are used to improve readability
  dfl <- ftWrdBnk
  vwl <- valWordList

  # variables to build final data frame
  numUses <- numeric(length(dfl))
  valanceValue <- numeric(length(dfl))
  rowTotal <- numeric(length(dfl))

  #loop
  numUses <- foreach(i=1:length(dfl), .combine=c, .packages="qdap") %dopar% {
    length(boolean_search(dfBnk$FullText, dfl[i]))
  }


  # insert breaks for REGEX
  dfl<- gsub("$", "\\\\b", dfl, perl = TRUE)
  # loop parses dfl and stores in w to use in REGEX
  #  REGEX returns valence value of valWord
  valanceValue <- foreach(i=1:length(dfl), .combine=c, .packages="qdap") %dopar% {
    p <- vwl[which(sapply(vwl$word,function(x) grepl(dfl[i], x))), 2]
    valanceValue[i] <- p[1]
  }
  stopCluster(cl)

  # Remove breaks for REGEX
  dfl<- gsub("\\\\b", "", dfl, perl = TRUE)


  # build temporary data frame with components
  dfTemp <- data.frame(dfl, numUses, valanceValue, stringsAsFactors = FALSE)

  # loop calculates the product of value and numUses
  for (i in 1:(length(dfl))){
    m1 <- dfTemp$numUses[i]
    m2 <- dfTemp$valanceValue[i]
    rowTotal[i] <- m1 * m2
  }

  # build general sentiment data frame
  ovrAllSent <- data.frame(dfl, numUses, valanceValue, rowTotal)
  return(ovrAllSent)

}


OverallSent100 <- function(ftWrdBnk, dfBnk) { #time saver
  #import packages
  library(foreach)
  library(doParallel)

  #setup parallel backend to use 8 processors
  cl<-makeCluster(8)
  registerDoParallel(cl)

  # featWrdsBankName contains all valWords found in texts
  #  aliases are used to improve readability
  dfl <- ftWrdBnk[1:200] ## <<<<<===============XXXXXXXXXXXXXX||Change this number to reduce runtime||XXXXXXXXXXXXXX
  vwl <- valWordList

  # variables to build final data frame
  numUses <- numeric(length(dfl))
  valanceValue <- numeric(length(dfl))
  rowTotal <- numeric(length(dfl))

  #loop
  numUses <- foreach(i=1:length(dfl), .combine=c, .packages="qdap") %dopar% {
    length(boolean_search(dfBnk$FullText, dfl[i]))
  }


  # insert breaks for REGEX
  dfl<- gsub("$", "\\\\b", dfl, perl = TRUE)
  # loop parses dfl and stores in w to use in REGEX
  #  REGEX returns valence value of valWord
  valanceValue <- foreach(i=1:length(dfl), .combine=c, .packages="qdap") %dopar% {
    p <- vwl[which(sapply(vwl$word,function(x) grepl(dfl[i], x))), 2]
    valanceValue[i] <- p[1]
  }
  stopCluster(cl)

  # Remove breaks for REGEX
  dfl<- gsub("\\\\b", "", dfl, perl = TRUE)


  # build temporary data frame with components
  dfTemp <- data.frame(dfl, numUses, valanceValue, stringsAsFactors = FALSE)

  # loop calculates the product of value and numUses
  for (i in 1:(length(dfl))){
    m1 <- dfTemp$numUses[i]
    m2 <- dfTemp$valanceValue[i]
    rowTotal[i] <- m1 * m2
  }

  # build general sentiment data frame
  ovrAllSent <- data.frame(dfl, numUses, valanceValue, rowTotal)
  return(ovrAllSent)

}

