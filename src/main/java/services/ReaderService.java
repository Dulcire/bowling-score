package services;

import model.entities.Shot;

import java.util.List;

/**
 * ReaderService.
 */
public interface ReaderService {

    List<Shot> readDataFile(String input);
}
