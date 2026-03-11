package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.entity.Item;
import at.technikum.springrestbackend.repository.ItemRepository;
import at.technikum.springrestbackend.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemServiceSaveTest {

    @Test
    void save_item_returns_saved_item() {

        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        ItemService service = new ItemService(itemRepository, userRepository);

        Item item = new Item();
        item.setTitle("Phone");

        Mockito.when(itemRepository.save(item)).thenReturn(item);

        Item saved = service.save(item);

        assertEquals("Phone", saved.getTitle());
    }
}