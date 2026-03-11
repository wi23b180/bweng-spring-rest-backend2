package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.entity.Item;
import at.technikum.springrestbackend.repository.ItemRepository;
import at.technikum.springrestbackend.repository.UserRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemServiceGetTest {

    @Test
    void get_all_items_returns_list() {

        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        ItemService service = new ItemService(itemRepository, userRepository);

        Item item = new Item();
        item.setId(1L);

        Mockito.when(itemRepository.findAll()).thenReturn(List.of(item));

        List<Item> result = service.getAllItems();

        assertEquals(1, result.size());
    }
}