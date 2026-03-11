package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.entity.Item;
import at.technikum.springrestbackend.entity.Role;
import at.technikum.springrestbackend.entity.User;
import at.technikum.springrestbackend.repository.ItemRepository;
import at.technikum.springrestbackend.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemServiceForbiddenTest {

    @Test
    void delete_item_forbidden() {

        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        ItemService service = new ItemService(itemRepository, userRepository);

        User user = new User();
        user.setId(2L);
        user.setRole(Role.USER);

        Item item = new Item();
        item.setId(1L);
        item.setOwner(null);

        Mockito.when(itemRepository.findById(1L))
            .thenReturn(Optional.of(item));

        Mockito.when(userRepository.findByUsername("lama"))
            .thenReturn(Optional.of(user));

        assertThrows(ResponseStatusException.class,
            () -> service.delete(1L, "lama"));
    }
}