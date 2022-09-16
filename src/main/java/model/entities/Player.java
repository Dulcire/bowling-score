package model.entities;

import lombok.Data;

import java.util.List;

/**
 * Player Class.
 */
@Data
public class Player {

    private String name;
    private List<Integer> pinFalls;
    private List<Frame> frames;

    public Player(final String name, final List<Integer> pinFalls, final List<Frame> frames) {
        this.name = name;
        this.pinFalls = pinFalls;
        this.frames = frames;
    }


}
