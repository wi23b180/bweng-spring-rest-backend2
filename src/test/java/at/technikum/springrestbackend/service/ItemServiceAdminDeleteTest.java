package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.entity.Item;
import at.technikum.springrestbackend.entity.Role;
import at.technikum.springrestbackend.entity.User;
import at.technikum.springrestbackend.repository.ItemRepository;
import at.technikum.springrestbackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

class ItemServiceAdminDeleteTest {

    @Test
    void delete_foreign_item_as_admin_calls_repository() {
        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        ItemService service = new ItemService(itemRepository, userRepository);

        User owner = new User();
        owner.setId(1L);
        owner.setRole(Role.USER);

        User admin = new User();
        admin.setId(2L);
        admin.setUsername("admin");
        admin.setRole(Role.ADMIN);

        Item item = new Item();
        item.setId(10L);
        item.setOwner(owner);

        Mockito.when(itemRepository.findById(10L)).thenReturn(Optional.of(item));
        Mockito.when(userRepository.findByUsername("admin")).thenReturn(Optional.of(admin));

        service.delete(10L, "admin");

        Mockito.verify(itemRepository).deleteById(10L);
    }
}