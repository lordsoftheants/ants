package lordsoftheants.ants.game;

import lordsoftheants.ants.api.AntShell;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Adrian Scripca
 */
public class GameState {
    public List<AntShell> antShells = new LinkedList<>();
    private boolean playing;
    private int lastAntId = 0;
    private int frameNumber = 0;
    private GameBoard board;
    private int maxAntsPerPlayer;

    public GameBoard getBoard() {
        return board;
    }

    public void setBoard(GameBoard board) {
        this.board = board;
    }

    public boolean isPlaying() {
        return playing;
    }

    private void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public void nextFrame() {
        frameNumber++;
    }

    public void startPlaying() {
        reset();
        setPlaying(true);
    }

    public void stopPlaying() {
        setPlaying(false);
    }

    public boolean isFinished() {
//        return frameNumber > 20;
        return false;
    }

    public int nextAntId() {
        return lastAntId++;
    }

    private void reset() {
        lastAntId = 0;
        playing = false;
        frameNumber = 0;
    }

    public List<AntShell> getAntsForPlayer(Player player) {
        List<AntShell> result = new LinkedList<>();
        for (AntShell ant : antShells) {
            if (ant.getOwner() == player) {
                result.add(ant);
            }
        }
        return result;
    }

    public int getMaxAntsPerPlayer() {
        return maxAntsPerPlayer;
    }

    public void setMaxAntsPerPlayer(int maxAntsPerPlayer) {
        this.maxAntsPerPlayer = maxAntsPerPlayer;
    }
}
