package services.impl;

import exceptions.DataException;
import lombok.SneakyThrows;
import model.entities.Shot;
import model.enums.ExceptionType;
import services.ShotService;

public class ShotServiceImpl implements ShotService {

    /**
     * Method to save Shots.
     *
     * @param data from File
     * @return
     */
    @SneakyThrows
    @Override
    public Shot save(final String[] data) {
        try {
            return new Shot(data[0], data[1]);
        } catch (RuntimeException e) {
            throw new DataException(ExceptionType.DATA_FORMAT_ERROR.getMessage());
        }

    }
}
