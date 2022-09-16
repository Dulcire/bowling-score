package services.impl;

import exceptions.DataException;
import exceptions.FileNotFound;
import lombok.SneakyThrows;
import model.entities.Shot;
import model.enums.Constants;
import model.enums.ExceptionType;
import services.ReaderService;
import services.ShotService;
import utils.Validations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation class to read a file.
 */
public class FileReaderServiceImpl implements ReaderService {

    private ShotService shotService;
    private static final Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public FileReaderServiceImpl(final ShotService service) {
        this.shotService = service;
    }

    /**
     * Method to get a file and read it and return a list of Shots.
     * @return List
     */
    @SneakyThrows
    @Override
    public List<Shot> readDataFile(final String input) {
        try {

            final Stream<String> stream = Files.lines(Paths.get(input));
            LOGGER.log(Level.INFO, String.format("Processing input file %s", input));
            final List<Shot> shots = stream.map(linea -> linea.split(Constants.TAB.getMessage()))
                    .map((String[] play) -> {
                        return shotService.save(play);
                    })
                    .collect(Collectors.toList());
            Validations.dataValidation(shots);
            return shots;
        } catch (DataException e) {
            throw new DataException(e.getMessage());
        } catch (IOException e) {
            throw new FileNotFound(ExceptionType.PATH_NOT_FOUND.getMessage());
        }
    }
}
