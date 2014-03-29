package ru.badver.study.canyonbunny;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;

public class Main {
	private static boolean rebuildAtlas = false;
	private static boolean drawDebugOutline = false;

	public static void main(String[] args) {
		// перестраиваем атлас, если нужно
		if (rebuildAtlas) {
			Settings settings = new Settings();
			settings.maxWidth = 1024;
			settings.maxHeight = 1024;
			settings.debug = drawDebugOutline;
			
			// упаковываем картинки
			TexturePacker.process(settings, "assets-raw/images",
					"../CanyonBunny-android/assets/images", "canyonbunny.pack");
			
			// упаковываем элементы интерфейса
			TexturePacker.process(settings, "assets-raw/images-ui",
					"../CanyonBunny-android/assets/images",
					"canyonbunny-ui.pack");
		}

		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Canyon Bunny";
		cfg.useGL20 = true;
		cfg.width = 1480;
		cfg.height = 800;
		cfg.fullscreen=false;
		cfg.resizable=true;
		

		new LwjglApplication(new CanyonBunnyMain(), cfg);
	}
}
