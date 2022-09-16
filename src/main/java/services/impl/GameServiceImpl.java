package services.impl;

import lombok.SneakyThrows;
import model.entities.Frame;
import services.GameService;
import utils.FrameUtils;

import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService {

    /**
     * Method to create the list of frames from a player.
     * @param pinfalls List of pinfalls
     * @return
     */
    @SneakyThrows
    @Override
    public List<Frame> createGameFrames(final List<Integer> pinfalls) {
        Integer scoreAcum = 0;
        final List<Frame> frames = new ArrayList<Frame>();
        Integer shot = 0;

        while (frames.size() < 9) {
            final Frame frame = FrameUtils.frameType(shot, pinfalls);
            scoreAcum = frame.socreCalculatio(shot, pinfalls, scoreAcum);
            frame.setFrame(shot, pinfalls);
            frames.add(frame);
            shot = frame.nextShot(shot, pinfalls);
        }
        final Frame frame = FrameUtils.frameType(shot, pinfalls);
        frame.socreCalculatio(shot, pinfalls, scoreAcum);
        frame.setLastFrame(shot, pinfalls);
        frames.add(frame);
        return frames;
    }

}
