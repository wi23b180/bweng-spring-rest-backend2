package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.service.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
@AutoConfigureMockMvc(addFilters = false)
class ItemControllerDeleteTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @MockBean
    private Authentication authentication;

    @Test
    void delete_item_returns_200() throws Exception {
        Mockito.when(authentication.getName()).thenReturn("testuser");

        mockMvc.perform(delete("/api/items/1").principal(authentication))
            .andExpect(status().isOk());

        Mockito.verify(itemService)
            .delete(1L, "testuser");
    }
}