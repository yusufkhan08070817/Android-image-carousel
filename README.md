# Android Image Carousel Library
<img src="[image_url](https://soliloquywp.com/wp-content/uploads/2016/03/carousel_addon.png)" alt="Image Description" width="200" height="200">

## Overview
The Android Image Carousel Library is a versatile and customizable solution for implementing image carousels in Android applications. This library simplifies the process of integrating image carousels, allowing developers to create engaging and visually appealing interfaces with minimal effort.
## Features
* Easy Integration: Seamlessly integrate image carousels into your Android applications with just a few lines of code.
* Customizable: Customize various aspects of the carousel, including transition animations, image scaling, pagination indicators, and more, to suit your application's design and branding.
* Dynamic Content Loading: Support for dynamic loading of images from local resources, URLs, or a content provider enables the display of diverse image content.
* Responsive Design: Ensure consistent functionality and visual appeal across a wide range of Android devices and screen sizes.
* Accessibility: Incorporate accessibility features to ensure that users with disabilities can navigate and interact with the carousel effectively.
* custom animatation
## Installation 
To use the Android Image Carousel Library in your Android project, follow these steps:
Add it in your root build.gradle at the end of repositories:
## Step 1. Add the JitPack repository to your build file
````
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven ( url ="https://jitpack.io" )
		}
	}
````
## Step 2. Add the dependency
````
dependencies {
	        implementation 'com.github.yusufkhan08070817:Android-image-carousel:1.0.1'
	}
````
for kotlin gradle
````
dependencies {
	        implementation ("com.github.yusufkhan08070817:Android-image-carousel:1.0.1")
	}
````
Sync your project with Gradle to import the library.

## How to use
````
<com.example.kcimagecarousel.Lib.Image_Carousel
        android:id="@+id/ima"
        android:layout_width="300dp"
        android:layout_height="300dp"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"

        />

and for acrivity
val v: Image_Carousel=findViewById(R.id.ima)
        v.setImage_Carousel(this,R.color.gray,R.color.black,5000,Data,false,null)
````
* this -> is context
* R.color.gray -> unclected thumb
* R.color.black ->thumb
* 5000 -> delay
* Data -> Arraylist<Pair<Int,String>>()
* false -> custom animatation
* null -> animatation parth ed R.ani.uptodown
# Contributing
Contributions to the Android Image Carousel Library are welcome! To contribute, follow these steps:

* Fork the repository and create a new branch.
* Make your changes and ensure they adhere to the project's coding style and guidelines.
* Test your changes thoroughly.
* Submit a pull request detailing the changes you've made and their purpose.
License
This project is licensed under the MIT License.

# Contact
For questions, feedback, or support, contact khanyusuk340@gmail.com.





