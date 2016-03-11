# AnimatedVectorDrawableExample
Small example to show use of Animated Vector Drawables, using animation to change an X to a checkmark on a FAB.

Minimum SDK target is API 23 to make use of AnimationCallbacks for the AnimatedVectorDrawables. Similar functionality can be achieved using Handler.postDelayed() for your animation duration on pre API 23 devices. 

Animations on the Vectors do not use path morphing, and should be fully compatible with AnimatedVectorDrawableCompat.  
