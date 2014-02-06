package ru.badver.study.canyonbunny;

import ru.badver.study.canyonbunny.game.Assets;
import ru.badver.study.canyonbunny.screens.DirectedGame;
import ru.badver.study.canyonbunny.screens.MenuScreen;
import ru.badver.study.canyonbunny.screens.transitions.ScreenTransition;
import ru.badver.study.canyonbunny.screens.transitions.ScreenTransitionSlice;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.Interpolation;

public class CanyonBunnyMain extends DirectedGame {

	@Override
	public void create() {
		// Set Libgdx log level
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		// Load assets
		Assets.instance.init(new AssetManager());

		// Start game at menu screen
		ScreenTransition transition = ScreenTransitionSlice.init(2,
				ScreenTransitionSlice.UP_DOWN, 20, Interpolation.pow5Out);
		setScreen(new MenuScreen(this), transition);

	}
}
