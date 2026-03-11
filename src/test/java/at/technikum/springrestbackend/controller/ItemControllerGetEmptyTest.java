package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.service.ItemService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemControllerGetEmptyTest {

    @Test
    void get_items_returns_empty_list() {

        ItemService service = Mockito.mock(ItemService.class);

        ItemController controller = new ItemController(service);

        Mockito.when(service.getAllItems())
            .thenReturn(List.of());

        assertEquals(0, controller.getItems().size());
    }
}