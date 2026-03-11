package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.entity.Item;
import at.technikum.springrestbackend.repository.ItemRepository;
import at.technikum.springrestbackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemServiceUserNotFoundTest {

    @Test
    void delete_user_not_found_throws_404() {
        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        ItemService service = new ItemService(itemRepository, userRepository);

        Item item = new Item();
        item.setId(1L);

        Mockito.when(itemRepository.findById(1L)).thenReturn(Optional.of(item));
        Mockito.when(userRepository.findByUsername("lama")).thenReturn(Optional.empty());

        ResponseStatusException ex =
            assertThrows(ResponseStatusException.class,
                () -> service.delete(1L, "lama"));

        assertEquals(404, ex.getStatusCode().value());
    }
}