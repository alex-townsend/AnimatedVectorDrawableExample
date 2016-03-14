# AnimatedVectorDrawableExample
Small example to show use of Animated Vector Drawables, using animation to change an X to a checkmark on a FAB.

Minimum SDK target is API 23 to make use of AnimationCallbacks for the AnimatedVectorDrawables. Similar functionality can be achieved using Handler.postDelayed() for your animation duration on pre API 23 devices. 

Animations on the Vectors do not use path morphing, and should be fully compatible with AnimatedVectorDrawableCompat.  

Originally created to answer http://stackoverflow.com/questions/35944281/animate-fab-button-cross-to-mark.

#Mandatory awful quality GIF below

![](http://i.imgur.com/LXt3A5v.gif)
