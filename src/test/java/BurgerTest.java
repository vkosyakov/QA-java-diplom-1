;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends Burger{

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;
    Burger burger = new Burger();


    @Test
    public void testAddIngredient(){
        burger.addIngredient(ingredient);
        Assert.assertFalse(burger.ingredients.isEmpty());
}

    @Test
    public void testRemoveIngredient(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void testMoveIngredient(){
        Ingredient filling = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient sauce = new Ingredient (IngredientType.SAUCE,"Соус Spicy-X",90);
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.moveIngredient(1, 0);
        Assert.assertEquals(burger.ingredients.get(0),sauce);
    }

   @Test
    public void testGetPrice(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(5.00F);
        Mockito.when(ingredient.getPrice()).thenReturn(10.00F);
        Assert.assertEquals(20.00F,burger.getPrice(),0);

    }

    @Test
    public void getReceiptTest(){
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();

        Burger burgerSourBlackCutlet = new Burger();
        burgerSourBlackCutlet.setBuns(buns.get(0));
        burgerSourBlackCutlet.addIngredient(ingredients.get(1));
        burgerSourBlackCutlet.addIngredient(ingredients.get(3));
        String n = System.lineSeparator();
        String expectedSourBlackCutlet = new String(String.format("(==== black bun ====)" + n +
                "= sauce sour cream =" + n +
                "= filling cutlet =" + n +
                "(==== black bun ====)" + n
                + n +
                "Price: 500,000000") + n);
        Assert.assertEquals(burgerSourBlackCutlet.getReceipt(),expectedSourBlackCutlet);
    }

}


