import beans.Card;
import beans.CardType;
import beans.Player;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import service.GameService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bajadh on 6/11/2020.
 */
@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @Spy
    GameService gameService;

    List<Player> playerList = new ArrayList<>();


    @Before
    public void setUp(){

        Player player = new Player(1);

        List<Card> randomCards = FastList.newListWith(
                new Card(3, CardType.HEART),
                new Card(4,CardType.SPADE),
                new Card(5, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

         player = new Player(2);

         randomCards = FastList.newListWith(
                new Card(4, CardType.HEART),
                new Card(5,CardType.SPADE),
                new Card(6, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);


         player = new Player(3);

       randomCards = FastList.newListWith(
                new Card(5, CardType.HEART),
                new Card(6,CardType.SPADE),
                new Card(7, CardType.SPADE));
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

    }

    @Test
    public void testCheckWinnerSequence(){

            List<Player> activePlayers = gameService.checkWinner(playerList);
            Assert.assertEquals(1,activePlayers.size());
            Assert.assertEquals(4,activePlayers.get(0).getId());


    }

    @Test
    public void testCheckWinnerTrail(){

        playerList.clear();
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
                new Card(5,CardType.SPADE),
                new Card(6, CardType.SPADE));
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


        List<Player> activePlayers = gameService.checkWinner(playerList);
        Assert.assertEquals(1,activePlayers.size());
        Assert.assertEquals(3,activePlayers.get(0).getId());


    }

    @Test
    public void testCheckWinnerPair(){

        playerList.clear();
        Player player = new Player(1);

        List<Card> randomCards = FastList.newListWith(
                new Card(3, CardType.HEART),
                new Card(3,CardType.SPADE),
                new Card(5, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

        player = new Player(2);

        randomCards = FastList.newListWith(
                new Card(11, CardType.HEART),
                new Card(5,CardType.SPADE),
                new Card(6, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);


        player = new Player(3);

        randomCards = FastList.newListWith(
                new Card(5, CardType.HEART),
                new Card(10,CardType.SPADE),
                new Card(10, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

        player = new Player(4);

        randomCards = FastList.newListWith(
                new Card(7, CardType.HEART),
                new Card(8,CardType.SPADE),
                new Card(13, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);


        List<Player> activePlayers = gameService.checkWinner(playerList);
        Assert.assertEquals(1,activePlayers.size());
        Assert.assertEquals(3,activePlayers.get(0).getId());


    }

    @Test
    public void testCheckWinnerPair_1(){

        playerList.clear();
        Player player = new Player(1);

        List<Card> randomCards = FastList.newListWith(
                new Card(4, CardType.HEART),
                new Card(5,CardType.SPADE),
                new Card(5, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

        player = new Player(2);

        randomCards = FastList.newListWith(
                new Card(11, CardType.HEART),
                new Card(5,CardType.SPADE),
                new Card(6, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);


        player = new Player(3);

        randomCards = FastList.newListWith(
                new Card(5, CardType.HEART),
                new Card(10,CardType.SPADE),
                new Card(11, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);

        playerList.add(player);

        player = new Player(4);

        randomCards = FastList.newListWith(
                new Card(7, CardType.HEART),
                new Card(8,CardType.SPADE),
                new Card(13, CardType.SPADE));
        randomCards.sort(Comparator.comparingInt(Card::getNumber));
        player.setCardList(randomCards);
        playerList.add(player);


        List<Player> activePlayers = gameService.checkWinner(playerList);
        Assert.assertEquals(1,activePlayers.size());
        Assert.assertEquals(1,activePlayers.get(0).getId());


    }


}
