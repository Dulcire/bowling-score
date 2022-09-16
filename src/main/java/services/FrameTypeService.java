package services;

import java.util.List;

/**
 * FrameTypeService.
 */
public interface FrameTypeService {

    Integer socreCalculatio(final Integer shot, final List<Integer> pinFalls, final Integer acumScore);

    Integer nextShot(final Integer shot, final List<Integer> pinFalls);

    void setLastFrame(final Integer shot, final List<Integer> pinFalls);

    void setFrame(final Integer shot, final List<Integer> pinFalls);

}
