package ru.badver.study.canyonbunny;

import ru.badver.study.canyonbunny.game.Assets;
import ru.badver.study.canyonbunny.screens.MenuScreen;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;

public class CanyonBunnyMain extends Game {

	@Override
	public void create() {
		// Set Libgdx log level
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		
		// Load assets
		Assets.instance.init(new AssetManager());
		
		// Start game at menu screen
		setScreen(new MenuScreen(this));
	}
}
