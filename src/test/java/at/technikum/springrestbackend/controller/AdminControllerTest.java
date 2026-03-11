package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.entity.Item;
import at.technikum.springrestbackend.service.ItemService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdminControllerTest {

    @Test
    void get_all_items_returns_items_from_service() {

        ItemService service = Mockito.mock(ItemService.class);

        AdminController controller = new AdminController(service);

        Item item = new Item();
        item.setTitle("Laptop");

        Mockito.when(service.getAllItems())
            .thenReturn(List.of(item));

        List<Item> result = controller.getAllItems();

        assertEquals(1, result.size());
        assertEquals("Laptop", result.get(0).getTitle());
    }
}