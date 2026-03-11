package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.entity.Item;
import at.technikum.springrestbackend.service.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemControllerCreateTest {

    @Test
    void create_item_returns_item() {

        ItemService service = Mockito.mock(ItemService.class);

        Item item = new Item();
        item.setTitle("Laptop");

        Mockito.when(service.save(item)).thenReturn(item);

        ItemController controller = new ItemController(service);

        Item result = controller.createItem(item);

        assertEquals("Laptop", result.getTitle());
    }
}