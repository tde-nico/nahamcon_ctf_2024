package com.nahamcon2024.kittykittybangbang;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\t\u0010\u0012\u001a\u00020\u0013H\u0086 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/nahamcon2024/kittykittybangbang/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "mainImageView", "Landroid/widget/ImageView;", "mediaPlayer", "Landroid/media/MediaPlayer;", "overlayDisplayDuration", "", "overlayImageView", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "playSound", "resId", "", "showOverlayImage", "stringFromJNI", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MainActivity extends ComponentActivity {
    public static final Companion Companion = new Companion(null);
    private ImageView mainImageView;
    private MediaPlayer mediaPlayer;
    private final long overlayDisplayDuration = 1700;
    private ImageView overlayImageView;

    public final native String stringFromJNI();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i("kitty kitty bang bang", "Loading app...");
        setContentView(R.layout.activity_main);
        Log.i("kitty kitty bang bang", "Setting images...");
        View findViewById = findViewById(R.id.mainImageView);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mainImageView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.overlayImageView);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.overlayImageView = (ImageView) findViewById2;
        Log.i("kitty kitty bang bang", "App loaded!");
        ImageView imageView = this.mainImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainImageView");
            imageView = null;
        }
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.nahamcon2024.kittykittybangbang.MainActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean onCreate$lambda$0;
                onCreate$lambda$0 = MainActivity.onCreate$lambda$0(MainActivity.this, view, motionEvent);
                return onCreate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$0(MainActivity this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.i("kitty kitty bang bang", "Listening for taps...");
        if (motionEvent.getAction() == 0) {
            Log.i("kitty kitty bang bang", "Screen tapped!");
            this$0.showOverlayImage();
            this$0.playSound(R.raw.bang);
            Log.i("kitty kitty bang bang", "BANG!");
            Log.i("kitty kitty bang bang", "flag{" + this$0.stringFromJNI() + '}');
            return true;
        }
        return true;
    }

    private final void showOverlayImage() {
        Log.i("kitty kitty bang bang", "Displaying bang photo...");
        ImageView imageView = this.overlayImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayImageView");
            imageView = null;
        }
        imageView.setVisibility(0);
        new Handler().postDelayed(new Runnable() { // from class: com.nahamcon2024.kittykittybangbang.MainActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.showOverlayImage$lambda$1(MainActivity.this);
            }
        }, this.overlayDisplayDuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showOverlayImage$lambda$1(MainActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.overlayImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("overlayImageView");
            imageView = null;
        }
        imageView.setVisibility(8);
        Log.i("kitty kitty bang bang", "time and sound over");
    }

    private final void playSound(int i) {
        Log.i("kitty kitty bang bang", "Playing bang sound...");
        MediaPlayer mediaPlayer = this.mediaPlayer;
        MediaPlayer mediaPlayer2 = null;
        if (mediaPlayer != null) {
            if (mediaPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
                mediaPlayer = null;
            }
            mediaPlayer.release();
        }
        MediaPlayer create = MediaPlayer.create(this, i);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.mediaPlayer = create;
        if (create == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
        } else {
            mediaPlayer2 = create;
        }
        mediaPlayer2.start();
    }

    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/nahamcon2024/kittykittybangbang/MainActivity$Companion;", "", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        System.loadLibrary("kittykittybangbang");
    }
}