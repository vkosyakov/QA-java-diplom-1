import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    Ingredient sauce = new Ingredient(IngredientType.SAUCE,"test_sauce",100);
    Ingredient cutlet = new Ingredient(IngredientType.FILLING,"test_cutlet",200);

    @Test
    public void getPriceTest(){
        Assert.assertEquals(100,sauce.getPrice(),0);
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals("test_sauce",sauce.getName());
    }

    @Test
    public void getTypeTest(){
        Assert.assertEquals("FILLING",String.valueOf(cutlet.getType()));
        Assert.assertEquals("SAUCE",String.valueOf(sauce.getType()));
    }
}
