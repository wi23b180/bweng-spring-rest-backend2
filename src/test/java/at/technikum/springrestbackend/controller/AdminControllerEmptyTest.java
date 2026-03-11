package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.service.ItemService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AdminControllerEmptyTest {

    @Test
    void get_all_items_empty_list() {

        ItemService service = Mockito.mock(ItemService.class);

        AdminController controller = new AdminController(service);

        Mockito.when(service.getAllItems())
            .thenReturn(List.of());

        List result = controller.getAllItems();

        assertTrue(result.isEmpty());
    }
}