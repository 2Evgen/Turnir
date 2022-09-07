
package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

        Player player1 = new Player(1, "Neksen", 175);
        Player player2 = new Player(2, "Ontip", 60);
        Player player3 = new Player(3, "Uno", 98);
        Player player4 = new Player(4, "Retro", 60);


        @Test
        public void testAdd() {
            Game game = new Game();
            game.register(player1);
            game.register(player2);
            game.register(player3);
            game.register(player4);

            List<Player> actual = game.getAllPlayers();
            ArrayList<Player> expected = new ArrayList<>();
            expected.add(player1);
            expected.add(player2);
            expected.add(player3);
            expected.add(player4);


            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void test1() {
            Game game = new Game();
            game.register(player1);

            Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Neksen", "Retro"));
        }

        @Test
        public void test2() {
            Game game = new Game();
            game.register(player4);

            Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Neksen", "Retro"));
        }

        @Test
        public void test3() {
            Game game = new Game();
            game.register(player1);
            game.register(player4);

            int expected = 1;
            Assertions.assertEquals(expected, game.round("Neksen", "Retro"));
        }

        @Test
        public void testResult() {
            Game game = new Game();
            game.register(player2);
            game.register(player4);

            int expected = 0;
            Assertions.assertEquals(expected, game.round("Ontip", "Retro"));
        }

        @Test
        public void testWin() {
            Game game = new Game();
            game.register(player1);
            game.register(player4);

            int expected = 2;
            Assertions.assertEquals(expected, game.round("Retro","Neksen"));
        }
    }

