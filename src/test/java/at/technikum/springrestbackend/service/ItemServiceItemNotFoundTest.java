package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.repository.ItemRepository;
import at.technikum.springrestbackend.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemServiceItemNotFoundTest {

    @Test
    void delete_item_not_found() {

        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        ItemService service = new ItemService(itemRepository, userRepository);

        Mockito.when(itemRepository.findById(1L))
            .thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class,
            () -> service.delete(1L, "lama"));
    }
}