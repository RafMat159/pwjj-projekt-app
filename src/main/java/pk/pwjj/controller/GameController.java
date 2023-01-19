package pk.pwjj.controller;

import pk.pwjj.entity.Ranking;
import pk.pwjj.entity.User;
import pk.pwjj.repository.UserRepository;

import java.util.Optional;

public class GameController {

    public Integer updateRanking(String username, String message) {
        Optional<User> userOptional = UserRepository.getInstance().findUserByUsernameWithRanking(username);

        if (userOptional.isPresent()) {
            Ranking ranking = userOptional.get().getRanking();

            if (message.equals("win")) {
                ranking.setGameWin(ranking.getGameWin() + 1);
            } else if (message.equals("lose")) {
                ranking.setGameLost(ranking.getGameLost() + 1);
            }

            UserRepository.getInstance().updateRanking(ranking);
            return 0;
        }
        return -1;
    }

}

