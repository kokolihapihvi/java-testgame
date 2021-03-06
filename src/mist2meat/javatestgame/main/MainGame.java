package mist2meat.javatestgame.main;

import mist2meat.javatestgame.input.Input;
import mist2meat.javatestgame.states.GameState;
import mist2meat.javatestgame.states.GameStateIntro;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class MainGame extends BasicGame {

	private static GameState currentGameState;

	public MainGame() {
		super("Untitled spacegame");

		setGameState(new GameStateIntro());
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		container.setShowFPS(false);

		Input.setInput(container.getInput());
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.setColor(Color.white);
		currentGameState.draw(container, g);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		currentGameState.update(container, delta);
	}

	public static void setGameState(GameState newState) {
		if (currentGameState != null) {
			currentGameState.unload();
		}

		currentGameState = newState;
		currentGameState.init();
	}

}
