package atownsend.testproject;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  private AnimatedVectorDrawable crossAnimatedDrawable;
  private AnimatedVectorDrawable checkAnimatedDrawable;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

    // initial drawable
    crossAnimatedDrawable =
        (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.animated_clear, getTheme());

    // NOTE -- uses the API 23 animation call backs, for pre API 23 you can accomplish something like
    // this by using Handler.postDelayed with the duration of your animations to set the next image and
    // start it
    crossAnimatedDrawable.registerAnimationCallback(new Animatable2.AnimationCallback() {
      @Override public void onAnimationEnd(Drawable drawable) {
        fab.setImageDrawable(checkAnimatedDrawable);
        ((AnimatedVectorDrawable) fab.getDrawable()).start();
      }
    });

    // second drawable to animate in
    checkAnimatedDrawable =
        (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.animated_check, getTheme());

    fab.setImageDrawable(crossAnimatedDrawable);

    final Button startButton = (Button) findViewById(R.id.start_btn);

    Button resetButton = (Button) findViewById(R.id.reset_btn);

    resetButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        // reset just for demo purposes
        crossAnimatedDrawable.reset();
        checkAnimatedDrawable.reset();
        fab.setImageDrawable(crossAnimatedDrawable);
        startButton.setEnabled(true);
      }
    });

    startButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        v.setEnabled(false);
        ((AnimatedVectorDrawable) fab.getDrawable()).start();
      }
    });
  }

}
