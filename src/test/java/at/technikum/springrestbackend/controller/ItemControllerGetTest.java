package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.entity.Item;
import at.technikum.springrestbackend.service.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ItemControllerGetTest {

    @Test
    void get_items_returns_200() throws Exception {

        ItemService service = Mockito.mock(ItemService.class);

        Mockito.when(service.getAllItems())
            .thenReturn(List.of(new Item()));

        ItemController controller = new ItemController(service);

        MockMvc mockMvc =
            MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/api/items"))
            .andExpect(status().isOk());
    }
}