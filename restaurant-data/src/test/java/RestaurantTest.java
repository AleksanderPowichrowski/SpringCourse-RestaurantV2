import com.app.resturant.controller.RestaurantController;
import com.app.resturant.service.RestaurantServiceImpl;
import com.app.resturant.data.kitchen.Dish;
import com.app.resturant.data.kitchen.DishResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RestaurantTest {

    @Test
    public void somethingTest(){

        RestaurantController restaurantController = new RestaurantController(new RestaurantServiceImpl());
        DishResult dishResult = restaurantController.startOrder(new Dish("Spaghetti-Carbonara"));
        Assertions.assertTrue(dishResult.isDishFinished());

    }
}
