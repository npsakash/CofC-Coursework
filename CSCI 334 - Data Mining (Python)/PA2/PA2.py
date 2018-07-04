#In 1
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd


from sklearn import metrics
from sklearn.model_selection import train_test_split
from sklearn.datasets import fetch_mldata
from sklearn.neural_network import MLPClassifier
from sklearn.utils import shuffle   

from itertools import cycle
from scipy import interp




mnist = fetch_mldata('MNIST original')

#In 2
# rescale the data, use the traditional train/test split
X, y = mnist.data / 255.0 , mnist.target
X_train, X_test = X[:60000], X[60000:]
y_train, y_test = y[:60000], y[60000:]


#####http://saravanan-thirumuruganathan.github.io/cse5334Spring2015/assignments/PA2/PA2_MNIST_Classification_Boston_Regression.html#####
# trim data to only look at identifying 7 and 9 

#Get all the seven images
sevens_data = mnist.data[mnist.target==7]      
#Get all the nine images
nines_data = mnist.data[mnist.target==9]       
#Merge them to create a new dataset
binary_class_data = np.vstack([sevens_data, nines_data])    
binary_class_labels = np.hstack([np.repeat(7, sevens_data.shape[0]), np.repeat(9, nines_data.shape[0])])


#In order to make the experiments repeatable, we will seed the random number generator to a known value
# That way the results of the experiments will always be same
np.random.seed(1234)                        
#randomly shuffle the data
binary_class_data, binary_class_labels = shuffle(binary_class_data, binary_class_labels)  
print "Shape of data and labels are :" , binary_class_data.shape, binary_class_labels.shape   

#There are approximately 14K images of 7 and 9. 
#Let us take the first 5000 as training and remaining as test data                                          
training_data = binary_class_data[:5000]                                                  
training_labels = binary_class_labels[:5000]                                                   

testing_data = binary_class_data[5000:]                                                   
testing_labels = binary_class_labels[5000:] 
#####http://saravanan-thirumuruganathan.github.io/cse5334Spring2015/assignments/PA2/PA2_MNIST_Classification_Boston_Regression.html#####

##make testing labels binary 7==0, 9==1 

testing_labels[testing_labels == 7] = 0
testing_labels[testing_labels == 9] = 1

#In 4
mean_tpr = 0.0
mean_fpr = np.linspace(0, 1, 100)

colors = ('cyan', 'indigo', 'seagreen', 'yellow', 'blue')
lw = 2

architectures = ( (1000,) , (300,100), (500,150), (300, ), (50,250,50,250) )

i = 0
for i in range(5):
    mlp = MLPClassifier(hidden_layer_sizes= architectures[i], activation = "logistic", max_iter=50,
                    verbose=True, random_state=1,early_stopping= True,
                    learning_rate_init=.1, tol = 1e-6)
    print "Architecture # ", i+1
    
    #Fit classifier 
    probas_ = mlp.fit(training_data, training_labels).predict_proba(testing_data)
    
    print("Training set score: %f" % mlp.score(training_data, training_labels))
    print("Test set score: %f" % mlp.score(testing_data, testing_labels))
    
    # Compute ROC curve and area the curve
    fpr, tpr, thresholds = metrics.roc_curve(testing_labels, probas_[:, 1])
    mean_tpr += interp(mean_fpr, fpr, tpr)
    mean_tpr[0] = 0.0
    roc_auc = metrics.auc(fpr, tpr)
    plt.plot(fpr, tpr, lw=lw, color=colors[i],
             label='Architecture # %d (auc = %0.2f)' % (i+1, roc_auc))

    i += 1
    

plt.plot([0, 1], [0, 1], linestyle='--', lw=lw, color='k',
         label='Luck')

mean_tpr /= 5
mean_tpr[-1] = 1.0
mean_auc = metrics.auc(mean_fpr, mean_tpr)
plt.plot(mean_fpr, mean_tpr, color='g', linestyle='--',
         label='Mean ROC (auc = %0.2f)' % mean_auc, lw=lw)


plt.xlim([-0.05, 1.05])
plt.ylim([-0.05, 1.05])
plt.xlabel('False Positive Rate')
plt.ylabel('True Positive Rate')
plt.title('AUC For Different MLP Architectures')
plt.legend(loc="lower right",fontsize = 'small')
plt.figure(figsize=(10,10))

plt.show()

#5


