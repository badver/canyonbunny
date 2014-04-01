package ru.badver.study.canyonbunny;

import ru.badver.study.canyonbunny.game.Assets;
import ru.badver.study.canyonbunny.screens.DirectedGame;
import ru.badver.study.canyonbunny.screens.MenuScreen;
import ru.badver.study.canyonbunny.screens.transitions.ScreenTransition;
import ru.badver.study.canyonbunny.screens.transitions.ScreenTransitionSlice;
import ru.badver.study.canyonbunny.util.AudioManager;
import ru.badver.study.canyonbunny.util.GamePreferences;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Version;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.Interpolation;

public class CanyonBunnyMain extends DirectedGame {

	@Override
	public void create() {
		// Set Libgdx log level
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log("VERSION", Version.VERSION);

		// Load assets
		Assets.instance.init(new AssetManager());

		// Load preferences for audio settings and start playing music
		GamePreferences.instance.load();
		AudioManager.instance.play(Assets.instance.music.song01);

		// Start game at menu screen
		ScreenTransition transition = ScreenTransitionSlice.init(2,
				ScreenTransitionSlice.UP_DOWN, 20, Interpolation.pow5Out);
		setScreen(new MenuScreen(this), transition);

	}
}
