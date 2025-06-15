import pandas as pd
import numpy as np
import h5py
import glob
import matplotlib.pyplot as plt
%matplotlib inline
import tensorflow as tf

#mouting the drive
from google.colab import drive
drive.mount("/contentgdrive")

import os
os.chdir(r'/contentgdrive/MyDrive/')

path_single=r"TrainData/img/image_3000.h5"
path_single_mask=r'TrainData/mask/mask_3000.h5'

f_data=np.zeros((1,128,128,3)) # creates an empty array clled f-data with a shape
with h5py.File(path_single) as hdf:  #opens an hdf5 file and extracts an image
  ls = list(hdf.keys())
  print("ls",ls)
  data =np.array(hdf.get('img'))
  print("input data shape:",data.shape) #shape of image is printed
  plt.imshow(data[:, :,3:0:-1]) #subset of data or part of image is displayed

#the channel used in the below code represent the intensity of each color or spectral
# band in the image and they are used in image processing and analysis tasks
# i.e ' remote sensing, vegetation analysis.'
  data_red = data[:, :,3]   #extracts the specific color channels from image
  data_green = data[:, :,2] #here the last number '2' defines the channel no.
  data_blue = data[:, :,1]
  data_nir = data[:, :,7] #this represents the near-infrared channel
  data_rgb = data[:, :,3:0:-1]

  #here we calculate the ndvi(normalized difference vegetation index)
  data_ndvi = np.divide(data_nir - data_red,np.add(data_nir, data_red))
  #the calculated ndvi values are stored in the first channel (index 0) of 'f_data' array
  f_data[0,:,:,0]= data_ndvi
  f_data[0,:,:,1]= data[:, :, 12] #channel 12 is stored in second channel of f_data
  f_data[0,:,:,2]= data[:, :,13] #channel 13 is stored in third channel of f_data

#it then prints the shape of the calculatd data_ndvi and f-data
  print("data ndvi shape ", data_ndvi.shape, "f_data shape: ", f_data.shape)
  plt.imshow(data_ndvi) # displays data_ndvi using imshow

with h5py.File(path_single_mask) as hdf: #opens HDF5 file located in path_single_mask
  ls = list(hdf.keys()) #gets or retrieves a list of keys from the hdf5 file and stores it in ls variable
  print("ls",ls) #shows the names of the dataset
  data =np.array(hdf.get('mask')) #it get the data from hdf5 file under the key name mask, basically it assumes that there is a dataset named mask in that file
  print("input data shape:",data.shape)#prints the shape of the data
  # the shape means it will show the dimensions of the data i.e width,height , channels etc.
  plt.imshow(data) #shows the img

path_single=r"TrainData/img/image_10.h5"
path_single_mask=r'TrainData/mask/mask_1.h5'
TRAIN_PATH=r"TrainData/img/*.h5" #TRAIN_PATH it is basically a strinf that represents a file pattern
#it can be used with glob.glob to collect a list fo that HDF5 files
TRAIN_MASK=r'TrainData/mask/*.h5' #spresent a file pattern for mask

# the below is a numpy array with shape of(3799,..,..,..). it is used to store image data
#data like dimension for samples, width, height and 6 channels
TRAIN_XX=np.zeros((3799, 128, 128, 6))
TRAIN_YY =np.zeros((3799,128 ,128, 1))# numpy arry with single channel
all_train = sorted(glob.glob(TRAIN_PATH))# collect and match the file pattern with the path
all_mask = sorted(glob.glob(TRAIN_MASK))

#basically what we have done is, we have set up file paths and empty arrays
#for storing image and that mask data, then collecting and matching with patterns for
#data loading or processing pipeline

#testing for google colab GPU
import tensorflow as tf #tensorflow is basically used for image classification
tf.test.gpu_device_name()

#here we dont have a gpu configuration so it show empty string but when we anaylized
#how to congigure we got to know that we have to install tensorflow -gpu

#it iterates over pairs of image and mask file using enumerate loop
for i, (img, mask) in enumerate(zip(all_train, all_mask)):
  print(i, img, mask)
  with h5py.File(img) as hdf: # for each pair of image and mask file
    ls = list(hdf.keys())
    data = np.array(hdf.get('img')) # it extracts the data

    #assign small value for the nan(Not a Number) value
    data[np.isnan(data)] = 0.000001 # used to handle missing or invalid data points

    # calculates the values to normalize the data
    mid_rgb = data[:, :, 1:4].max() / 2.0
    mid_slope = data[:, :, 12].max() / 2.0
    mid_elevation = data[:, :, 13].max() / 2.0

    #ndvi calculaton
    data_red = data[:, :, 3]
    data_nir = data[:, :, 7]
    data_ndvi = np.divide(data_nir - data_red,np.add(data_nir,data_red))

    #final array
    TRAIN_XX[i, :, :, 0] = 1 - data[:, :, 3] / mid_rgb  #red
    TRAIN_XX[i, :, :, 1] = 1 - data[:, :, 2] / mid_rgb  #green
    TRAIN_XX[i, :, :, 2] = 1 - data[:, :, 1] / mid_rgb  #blue
    TRAIN_XX[i, :, :, 3] = data_ndvi #NDVI
    TRAIN_XX[i, :, :, 4] = 1 - data[:, :, 12] / mid_slope  #SLOPE
    TRAIN_XX[i, :, :, 5] = 1 - data[:, :, 13] / mid_elevation  #ELEVATION

  with h5py.File(mask) as hdf:
    ls = list(hdf.keys())
    data = np.array(hdf.get('mask'))
    TRAIN_YY[i, :, :, 0] = data  #creates a single channel output for the model
    #which is in binary mask for segmentation

#basically in above code we are training indorder to image segmentation
# data prepocessing includes data normalizaton, handling NaN values and feature extraction

# TRAIN_XX_n = TRAIN_XX / TRAIN_XX.max()
TRAIN_XX[np.isnan(TRAIN_XX)] = 0.000001
print(TRAIN_XX.min(), TRAIN_XX.max(), TRAIN_YY.min(), TRAIN_YY.max() )

#this loss function is used in image segmentaiton task
# and it also measures the similarity between predicted and true binary masks
def dice_loss(y_true,y_pred):# y_true is the binary mask and y_pred is predicted mask
  y_true = tf.cast(y_true, tf.float32) # here we check whether y-true and y_pred is of same data type or not
  y_pred = tf.math.sigmoid(y_pred)# here the sigmoid function is applid to y_pred tensor
  # this basically scales the values in y_pred between 0 and 1

 # the dice loss is calculated here
  numerator = 2 * tf.reduce_sum(y_true * y_pred)
  denominator = tf.reduce_sum(y_true + y_pred)

  return 1 - numerator / denominator

  #basically it indicates a better match btw the predicted and true mask
  
  img=234
fig,(ax1,ax2,ax3,ax4,ax5) = plt.subplots(1,5,figsize=(15,10))

ax1.set_title("RGB image")
ax2.set_title("NDVI")# ndvi(Normalized Difference Vegetation Index)
ax3.set_title("Slope")
ax4.set_title("Elevation")
ax5.set_title("Mask")
ax1.imshow(TRAIN_XX[img, :, :, 0:1])# this uses first three channels(0,1,2)
ax2.imshow(TRAIN_XX[img, :, :, 3])# selects ndvi channel to display
ax3.imshow(TRAIN_XX[img, :, :, 4])#selects the Slope channel to display.
ax4.imshow(TRAIN_XX[img, :, :, 5])
ax5.imshow(TRAIN_YY[img, :, :, 0])

#here image segmentaion is done

#This line imports the train_test_split function from the scikit-learn library,
#which is commonly used for splitting a dataset into training and validation sets.
from sklearn.model_selection import train_test_split

# Split the data
x_train, x_valid, y_train, y_valid = train_test_split(TRAIN_XX, TRAIN_YY, test_size=0.1, shuffle= True)

img=2432
fig,(ax1,ax2, ax3, ax4, ax5)= plt.subplots(1,5,figsize=(15,10))

ax1.set_title("RGB image")
ax2.set_title("NDVI")
ax3.set_title("Slope")
ax4.set_title("Elevation")
ax5.set_title("Mask")
ax1.imshow(x_train[img, :, :, 0:1])
ax2.imshow(x_train[img, :, :, 3])
ax3.imshow(x_train[img, :, :, 4])
ax4.imshow(x_train[img, :, :, 5])
ax5.imshow(y_train[img, :, :, 0])

x_train.shape, y_train.shape

del TRAIN_XX
del TRAIN_YY
del all_train
del all_mask

img=2456
fig,(ax1,ax2, ax3, ax4)= plt.subplots(1,4,figsize=(15,10))


ax1.set_title("RGB image")
ax2.set_title("NDVI")
ax3.set_title("SLOPE")
ax4.set_title("Mask")
ax1.imshow(x_train[img, :, :, 0:1])
ax2.imshow(x_train[img, :, :, 3])
ax3.imshow(x_train[img, :, :, 4])
ax4.imshow(y_train[img, :, :, 0])

#unet model
from utils import recall_m, precision_m, f1_m
def unet_model(IMG_WIDTH, IMG_HIGHT, IMG_CHANNELS):
  inputs = tf.keras.layers.Input((IMG_WIDTH, IMG_HIGHT, IMG_CHANNELS)) #it is input tensor of shape

  #Converted inputs to floating
  #s = tf.keras.layers.Lamda(lambda x:x/255)(inputs)

  #Contraction path
  #The model starts with a series of convolutional layers followed by max-pooling layers, which reduce the spatial dimensions while increasing the number of channels.
#c1, c2, c3, c4, and c5 are the convolutional layers.
#p1, p2, p3, and p4 are max-pooling layers.
#Each convolutional block consists of two convolutional layers with ReLU activation and dropout layers for regularization.
#Convolutional layers apply a convolution operation to the input, passing the result to the next layer.
# A convolution converts all the pixels in its receptive field into a single value.
  c1 = tf.keras.layers.Conv2D(16,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(inputs)
  c1 = tf.keras.layers.Dropout(0.1)(c1)
  c1 = tf.keras.layers.Conv2D(16,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(c1)
  p1 = tf.keras.layers.MaxPooling2D((2,2))(c1)

  c2 = tf.keras.layers.Conv2D(32,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(p1)
  c2 = tf.keras.layers.Dropout(0.1)(c2)
  c2 = tf.keras.layers.Conv2D(32,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(c2)
  p2 = tf.keras.layers.MaxPooling2D((2,2))(c2)

  c3 = tf.keras.layers.Conv2D(64,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(p2)
  c3 = tf.keras.layers.Dropout(0.2)(c3)
  c3 = tf.keras.layers.Conv2D(64,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(c3)
  p3 = tf.keras.layers.MaxPooling2D((2,2))(c3)

  c4 = tf.keras.layers.Conv2D(128,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(p3)
  c4 = tf.keras.layers.Dropout(0.2)(c4)
  c4 = tf.keras.layers.Conv2D(128,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(c4)
  p4 = tf.keras.layers.MaxPooling2D((2,2))(c4)

  c5 = tf.keras.layers.Conv2D(256,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(p4)
  c5 = tf.keras.layers.Dropout(0.3)(c5)
  c5 = tf.keras.layers.Conv2D(256,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(c5)

  #Expansive path
  u6 = tf.keras.layers.Conv2DTranspose(128,(2, 2), strides=(2,2), padding='same')(c5)
  u6 = tf.keras.layers.concatenate([u6, c4])
  c6 = tf.keras.layers.Conv2D(128,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(u6)
  c6 = tf.keras.layers.Dropout(0.2)(c6)
  c6 = tf.keras.layers.Conv2D(128,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(c6)

  u7 = tf.keras.layers.Conv2DTranspose(64,(2, 2), strides=(2,2), padding='same')(c6)
  u7 = tf.keras.layers.concatenate([u7, c3])
  c7 = tf.keras.layers.Conv2D(64,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(u7)
  c7 = tf.keras.layers.Dropout(0.2)(c7)
  c7 = tf.keras.layers.Conv2D(64,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(c7)

  u8 = tf.keras.layers.Conv2DTranspose(32,(2, 2), strides=(2,2), padding='same')(c7)
  u8 = tf.keras.layers.concatenate([u8, c2])
  c8 = tf.keras.layers.Conv2D(32,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(u8)
  c8 = tf.keras.layers.Dropout(0.1)(c8)
  c8 = tf.keras.layers.Conv2D(32,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(c8)

  u9 = tf.keras.layers.Conv2DTranspose(16,(2, 2), strides=(2,2), padding='same')(c8)
  u9 = tf.keras.layers.concatenate([u9, c1],axis = 3)
  c9 = tf.keras.layers.Conv2D(16,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(u9)
  c9 = tf.keras.layers.Dropout(0.1)(c9)
  c9 = tf.keras.layers.Conv2D(16,(3, 3), activation = 'relu', kernel_initializer='he_normal',padding='same')(c9)

  outputs = tf.keras.layers.Conv2D(1, (1,1), activation = 'sigmoid')(c9)

  model = tf.keras.Model(inputs=[inputs],outputs=[outputs])
  model.compile(optimizer= 'adam', loss = 'binary_crossentropy', metrics = ['accuracy',f1_m, precision_m, recall_m])

  return model

model = unet_model(128, 128, 6)
# model.summary()
checkpointer = tf.keras.callbacks.ModelCheckpoint("best_model.h5", monitor="val_f1_m", verbose=1, save_best_only=True, mode="max")
# earlyStopping = tf.keras.callbacks.EarlyStopping(monitor="val_f1_m", patience=10, verbose=1, mode='max')

callbacks = [
    # earlyStopping.
    checkpointer
]

history = model.fit(x_train, y_train, batch_size=8, epochs=100, verbose=2, validation_data=(x_valid, y_valid),
                    callbacks=callbacks)

model.save("model_save.h5")

#callback will save the best model based on the validation F1 score,
#and the training will proceed as intended.
#Make sure you have x_train, y_train, x_valid, and y_valid properly defined for your specific dataset.

results = model.evaluate(x_valid, y_valid, verbose=0)
loss = results[0]
accuracy = results[1]
f1_score = results[2]
precision = results[3]
recall = results[4]

print("Validation Loss:", loss)
print("Validation Accuracy:", accuracy)
print("Validation F1 Score:", f1_score)
print("Validation Precision:", precision)
print("Validation Recall:", recall)
# extract and print the validation loss, accuracy, F1 score,
# precision, and recall from the results obtained using the evaluate method.

#prediction
import matplotlib.pyplot as plt

fig, ((ax11, ax12), (ax13, ax14)) = plt.subplots(2, 2, figsize=(20, 15))

# Plot loss
ax11.plot(history.history['loss'])
ax11.plot(history.history['val_loss'])
ax11.set_title('Unet model loss')
ax11.set_ylabel('loss')
ax11.set_xlabel('epoch')
ax11.legend(['train', 'validation'], loc='upper left')

# Plot precision
ax12.plot(history.history['precision_m'])
ax12.plot(history.history['val_precision_m'])
ax12.set_title('Unet model precision')
ax12.set_ylabel('precision')
ax12.set_xlabel('epoch')
ax12.legend(['train', 'validation'], loc='upper left')

# Plot recall
ax13.plot(history.history['recall_m'])
ax13.plot(history.history['val_recall_m'])
ax13.set_title('Unet model recall')
ax13.set_ylabel('recall')
ax13.set_xlabel('epoch')
ax13.legend(['train', 'validation'], loc='upper left')

# Plot F1 score
ax14.plot(history.history['f1_m'])
ax14.plot(history.history['val_f1_m'])
ax14.set_title('Unet model f1')
ax14.set_ylabel('f1')
ax14.set_xlabel('epoch')
ax14.legend(['train', 'validation'], loc='upper left')

plt.show()

''' It should create a 2x2 grid of subplots, where each subplot displays
a different metric over the training epochs. Specifically, it plots the loss,
precision, recall, and F1 score for both the training and validation datasets.'''

threshold = 0.5 #"threshold" typically refers to a value or a condition used to make decisions, comparisons, or to filter data.
pred_img = model.predict(x_valid)#This line uses your trained model to make predictions on the validation data (x_valid) and stores the predicted images in the pred_img variable.
pred_img = (pred_img > threshold).astype(np.uint8)
'''This is a boolean comparison that checks if each pixel value in the pred_img array is greater than the specified threshold (0.5).
This creates a binary mask where True indicates values greater than 0.5,
 and False indicates values less than or equal to 0.5.
 .astype(np.uint8): This line converts the boolean values in the binary mask to 8-bit unsigned integer values.
 True becomes 1, and False becomes 0.'''
 
 img = 144
fig, (ax1, ax2, ax3) = plt.subplots(1, 3, figsize=(15, 10))

# Display model's predictions
ax1.imshow(pred_img[img, :, :, 0], cmap='gray')
ax1.set_title("Predictions")

# Display the corresponding label
ax2.imshow(y_valid[img, :, :, 0], cmap='gray')
ax2.set_title("Label")

# Display the input image
ax3.imshow(x_valid[img, :, :, 0:3])
ax3.set_title('Training Image')

plt.show()
'''This will ensure that the images are displayed in grayscale,
 which is typically appropriate for binary segmentation tasks.
  The input image is shown without any specific colormap because it's a color image with three channels.'''
  
#validation data
validation_url = r'/content/gdrive/MyDrive/ValidData/img/*.h5'
img_val = sorted(glob.glob(validation_url))

VAL_XX = np.zeros((245, 128, 128, 6))
mask_name = []
for i, img in enumerate(img_val):
    print(i, img)
    mask_name.append(img.split('/')[-1].replace('image', 'mask'))
    with h5py.File(img) as hdf:
        ls = list(hdf.keys())
        data = np.array(hdf.get('img'))

        # assign 0 for the nan value
        data[np.isnan(data)] = 0.000001

        # to normalize the data
        mid_rgb = data[:, :, 1:4].max() / 2.0
        mid_slope = data[:, :, 12].max() / 2.0
        mid_elevation = data[:, :, 13].max() / 2.0

        # ndvi calculation
        data_red = data[:, :, 3]
        data_nir = data[:, :, 7]
        data_ndvi = np.divide(data_nir - data_red,np.add(data_nir, data_red))

        # final array
        VAL_XX[i, :, :, 0] = 1 - data[:, :, 3] / mid_rgb #RED
        VAL_XX[i, :, :, 1] = 1 - data[:, :, 2] / mid_rgb #GREEN
        VAL_XX[i, :, :, 2] = 1 - data[:, :, 1] / mid_rgb #BLUE
        VAL_XX[i, :, :, 3] = data_ndvi #NDVI
        VAL_XX[i, :, :, 4] = 1- data[:, :, 13] / mid_slope #SLOPE
        VAL_XX[i, :, :, 5] = 1 - data[:, :, 13] / mid_elevation #ELEVATION
 
#prediction for validation data       
threshold = 0.5
pred_img = model.predict(VAL_XX)
pred_img = (pred_img > threshold).astype(np.uint8)
pred_img.shape

#visaualization on validation data
img = 167
fig,(ax1,ax2)= plt.subplots(1,2,figsize=(15,10))
ax1.imshow(pred_img[img, :, :, 0])
ax1.set_title("Predictions")
ax2.imshow(VAL_XX[img, :, :, 0:3])
ax2.set_title('Training Image')

#write directory
write_directory = r'/content/gdrive/MyDrive/ValidData/mask'
for i, name in enumerate(mask_name):
  h5f = h5py.File(write_directory + "/" + name, 'w')
  # change the dimention of prediction to (n, 128, 128)
  pred_mask = pred_img[i, :, :, 0]

  # write to the directory
  h5f.create_dataset('mask', data = pred_mask)
  h5f.close()