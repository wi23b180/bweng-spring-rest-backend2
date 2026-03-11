package at.technikum.springrestbackend.repository;

import at.technikum.springrestbackend.entity.Item;
import at.technikum.springrestbackend.entity.ItemType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Page<Item> findByType(ItemType type, Pageable pageable);

    Page<Item> findByCategoryIgnoreCase(String category, Pageable pageable);

    Page<Item> findByTypeAndCategoryIgnoreCase(ItemType type, String category, Pageable pageable);
}