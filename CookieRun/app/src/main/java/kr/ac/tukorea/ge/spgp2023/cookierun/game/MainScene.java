package kr.ac.tukorea.ge.spgp2023.cookierun.game;

import android.view.MotionEvent;

import kr.ac.tukorea.ge.spgp2023.cookierun.R;
import kr.ac.tukorea.ge.spgp2023.framework.scene.BaseScene;
import kr.ac.tukorea.ge.spgp2023.framework.view.Metrics;

public class MainScene extends BaseScene {
    private final Player player;

    public enum Layer {
        bg, player, COUNT
    }
    public MainScene() {
        Metrics.setGameSize(16.0f, 9.0f);
        initLayers(Layer.COUNT);

        add(Layer.bg, new VertScrollBackground(R.mipmap.cookie_run_bg_1, 1.0f));
        add(Layer.bg, new VertScrollBackground(R.mipmap.cookie_run_bg_2, 2.0f));
        add(Layer.bg, new VertScrollBackground(R.mipmap.cookie_run_bg_3, 3.0f));

        player = new Player();
        add(Layer.player, player);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            player.jump();
        }
        return super.onTouchEvent(event);
    }
}