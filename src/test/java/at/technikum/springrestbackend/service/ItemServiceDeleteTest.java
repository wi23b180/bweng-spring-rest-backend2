package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.entity.Item;
import at.technikum.springrestbackend.entity.Role;
import at.technikum.springrestbackend.entity.User;
import at.technikum.springrestbackend.repository.ItemRepository;
import at.technikum.springrestbackend.repository.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ItemServiceDeleteTest {

    @Test
    void delete_item_calls_repository() {

        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        ItemService service = new ItemService(itemRepository, userRepository);

        User user = new User();
        user.setId(1L);
        user.setUsername("lama");
        user.setRole(Role.USER);

        Item item = new Item();
        item.setId(1L);
        item.setOwner(user);

        Mockito.when(itemRepository.findById(1L)).thenReturn(Optional.of(item));
        Mockito.when(userRepository.findByUsername("lama")).thenReturn(Optional.of(user));

        service.delete(1L, "lama");

        Mockito.verify(itemRepository).deleteById(1L);
    }
}