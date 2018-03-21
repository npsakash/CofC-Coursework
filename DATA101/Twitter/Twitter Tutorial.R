#Twitter Text Mining
install.packages("twitteR")
## Option 1: retrieve tweets from Twitter
library(twitteR)
tweets <- userTimeline("RDataMining", n = 3200)

url <- "http://www.rdatamining.com/data/rdmTweets-201306.RData"
download.file(url, destfile = "./data/rdmTweets-201306.RData")

load(file = "rdmTweets-201306.RData")
(n.tweet <- length(tweets))

tweets.df <- twListToDF(tweets)
dim(tweets.df)

for (i in c(1:2, 320)) f
cat(paste0("[", i, "] "))
writeLines(strwrap(tweets.df$text[i], 60))
g
