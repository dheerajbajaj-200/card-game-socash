package service;


import beans.Card;
import beans.CardType;
import beans.Player;
import exception.NoWinnerFoundException;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import runner.Game;
import strategies.StandardWinningStrategy;
import strategies.TopFaceCardTieBreakingStrategy;
import utils.FixedCardDealerTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    Game game;

    FixedCardDealerTest cardDealer = new FixedCardDealerTest();
    @Before
    public void setUp(){
        game = new Game(0,
             cardDealer,
             3,
             new StandardWinningStrategy(FastList.newListWith(new TrailRule(),new SequenceRule(),new PairRule(),new TopFaceCardRule())),
             new TopFaceCardTieBreakingStrategy(1,FastList.newListWith(new TopFaceCardRule())));


    }

    @Test
    public void testTrail() throws NoWinnerFoundException {

        List<Player> playerList = new ArrayList<>();
        Player player = new Player(1);

        List<Card> randomCards = FastList.newListWith(
                new Card(3, CardType.HEART),
                new Card(3,CardType.SPADE),
                new Card(3, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

        player = new Player(2);

        randomCards = FastList.newListWith(
                new Card(4, CardType.HEART),
                new Card(4,CardType.SPADE),
                new Card(4, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);


        player = new Player(3);

        randomCards = FastList.newListWith(
                new Card(5, CardType.HEART),
                new Card(5,CardType.SPADE),
                new Card(5, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

        player = new Player(4);

        randomCards = FastList.newListWith(
                new Card(7, CardType.HEART),
                new Card(8,CardType.SPADE),
                new Card(9, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);
        game.setPlayerList(playerList);

        Player winner = game.playGame();
        Assert.assertEquals(3,winner.getId());

    }


    @Test
    public void testPair() throws NoWinnerFoundException {

        List<Player> playerList = new ArrayList<>();
        Player player = new Player(1);

        List<Card> randomCards = FastList.newListWith(
                new Card(3, CardType.HEART),
                new Card(3,CardType.SPADE),
                new Card(4, CardType.CLUB));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

        player = new Player(2);

        randomCards = FastList.newListWith(
                new Card(4, CardType.HEART),
                new Card(4,CardType.SPADE),
                new Card(5, CardType.CLUB));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);


        player = new Player(3);

        randomCards = FastList.newListWith(
                new Card(5, CardType.HEART),
                new Card(6,CardType.SPADE),
                new Card(8, CardType.CLUB));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

        player = new Player(4);

        randomCards = FastList.newListWith(
                new Card(7, CardType.HEART),
                new Card(8,CardType.SPADE),
                new Card(10, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);
        game.setPlayerList(playerList);

        Player winner = game.playGame();
        Assert.assertEquals(2,winner.getId());

    }

    @Test
    public void testSequence() throws NoWinnerFoundException {

        List<Player> playerList = new ArrayList<>();
        Player player = new Player(1);

        List<Card> randomCards = FastList.newListWith(
                new Card(3, CardType.HEART),
                new Card(4,CardType.SPADE),
                new Card(5, CardType.CLUB));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

        player = new Player(2);

        randomCards = FastList.newListWith(
                new Card(4, CardType.HEART),
                new Card(4,CardType.SPADE),
                new Card(5, CardType.CLUB));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);


        player = new Player(3);

        randomCards = FastList.newListWith(
                new Card(5, CardType.HEART),
                new Card(6,CardType.SPADE),
                new Card(7, CardType.CLUB));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

        player = new Player(4);

        randomCards = FastList.newListWith(
                new Card(7, CardType.HEART),
                new Card(8,CardType.SPADE),
                new Card(10, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);
        game.setPlayerList(playerList);

        Player winner = game.playGame();
        Assert.assertEquals(3,winner.getId());

    }

    @Test
    public void testTopFaceCard() throws NoWinnerFoundException {

        List<Player> playerList = new ArrayList<>();
        Player player = new Player(1);

        List<Card> randomCards = FastList.newListWith(
                new Card(3, CardType.HEART),
                new Card(5,CardType.SPADE),
                new Card(6, CardType.CLUB));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

        player = new Player(2);

        randomCards = FastList.newListWith(
                new Card(4, CardType.HEART),
                new Card(6,CardType.SPADE),
                new Card(8, CardType.CLUB));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);


        player = new Player(3);

        randomCards = FastList.newListWith(
                new Card(5, CardType.HEART),
                new Card(7,CardType.SPADE),
                new Card(9, CardType.CLUB));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

        player = new Player(4);

        randomCards = FastList.newListWith(
                new Card(1, CardType.HEART),
                new Card(2,CardType.SPADE),
                new Card(4, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);
        game.setPlayerList(playerList);

        Player winner = game.playGame();
        Assert.assertEquals(4,winner.getId());

    }

    @Test
    public void testTieBreaker() throws NoWinnerFoundException {

        List<Player> playerList = new ArrayList<>();
        Player player = new Player(1);

        List<Card> randomCards = FastList.newListWith(
                new Card(1, CardType.HEART),
                new Card(5,CardType.SPADE),
                new Card(6, CardType.CLUB));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

        player = new Player(2);

        randomCards = FastList.newListWith(
                new Card(4, CardType.HEART),
                new Card(6,CardType.SPADE),
                new Card(8, CardType.CLUB));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);


        player = new Player(3);

        randomCards = FastList.newListWith(
                new Card(5, CardType.HEART),
                new Card(7,CardType.SPADE),
                new Card(9, CardType.CLUB));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

        player = new Player(4);

        randomCards = FastList.newListWith(
                new Card(2, CardType.HEART),
                new Card(1,CardType.SPADE),
                new Card(4, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);
        game.setPlayerList(playerList);

        List<Card> cards = FastList.newListWith(new Card(2, CardType.HEART),
                new Card(1,CardType.SPADE),
                new Card(4, CardType.SPADE));

        cardDealer.setTestCards(new ArrayList<>(cards));
        Player winner = game.playGame();
        Assert.assertEquals(4,winner.getId());

    }
}
