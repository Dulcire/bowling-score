package services;

import model.entities.Frame;

import java.util.List;

/**
 * GameService.
 */
public interface GameService {

    List<Frame> createGameFrames(final List<Integer> pinfalls);
}
