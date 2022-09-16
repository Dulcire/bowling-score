import model.entities.Player;
import model.entities.Shot;
import services.*;
import services.impl.*;

import java.util.Arrays;
import java.util.List;

public class JavaBowlingApplication {


    public static void main(final String[] args) {
        final ReaderService fileReaderService;
        final ShotService shotService = new ShotServiceImpl();
        final GameService gameService = new GameServiceImpl();
        final PlayerService playerService = new PlayerServiceImpl(gameService);
        final OutputService outputService = new OutputServiceImpl();

        if (Arrays.stream(args).findFirst().isPresent()) {
            fileReaderService = new FileReaderServiceImpl(shotService);
            final List<Shot> shots =  fileReaderService.readDataFile(Arrays.stream(args).findFirst().get());
            final List<Player> players = playerService.createPlayers(shots);
            outputService.printGame(players);
        } else {
            System.out.println("File path is missing");
        }

    }
}
