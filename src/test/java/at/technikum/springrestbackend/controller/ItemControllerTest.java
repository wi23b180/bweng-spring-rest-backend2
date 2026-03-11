package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.entity.Item;
import at.technikum.springrestbackend.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
@AutoConfigureMockMvc(addFilters = false)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void get_items_returns_200() throws Exception {

        Item item = new Item();
        item.setId(1L);

        Mockito.when(itemService.getAllItems())
            .thenReturn(List.of(item));

        mockMvc.perform(get("/api/items"))
            .andExpect(status().isOk());
    }

    @Test
    void create_item_returns_200() throws Exception {

        Item item = new Item();
        item.setId(1L);

        Mockito.when(itemService.save(Mockito.any()))
            .thenReturn(item);

        mockMvc.perform(post("/api/items")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(item)))
            .andExpect(status().isOk());
    }
}