package model.entities;

import lombok.Data;
import services.FrameTypeService;

/**
 * Class to create Frames.
 */
@Data
public abstract class Frame implements FrameTypeService {

    private Integer score;
    private Integer firstShot;
    private Integer thirdShot;
    private Integer secodnShot;
    private String printFrame;


    public Frame() {
        score = 0;
        firstShot = 0;
        secodnShot = 0;
        thirdShot = 0;
        printFrame = "";
    }

    public Frame(final Integer firstShot, final Integer secodnShot, final Integer thirdShot, final Integer score, final String printFrame) {
        this.firstShot = firstShot;
        this.secodnShot = secodnShot;
        this.thirdShot = thirdShot;
        this.printFrame = printFrame;
        this.score = score;
    }


}
