package samuel.tutorials.console;

import lombok.extern.slf4j.Slf4j;
import samuel.tutorials.Game;
import samuel.tutorials.MessageGenerator;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


import java.util.Scanner;

@Slf4j
@Component
public class  ConsoleNumberGuess {

    private final Game game;
    private final MessageGenerator messageGenerator;

    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void Start() {
        log.info("start ()----> Container ready for use.");

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n");

                String playAgain = scanner.nextLine().trim();
                if(!playAgain.equalsIgnoreCase("y")) {
                    break;
                }

                game.reset();
            }
        }
    }
}
