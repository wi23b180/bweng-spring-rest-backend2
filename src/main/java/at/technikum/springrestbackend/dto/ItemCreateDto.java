package at.technikum.springrestbackend.dto;

import at.technikum.springrestbackend.entity.ItemType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ItemCreateDto {

    @NotBlank(message = "title is required")
    @Size(min = 3, max = 100, message = "title must be between 3 and 100 characters")
    private String title;

    @NotBlank(message = "description is required")
    @Size(min = 5, max = 1000, message = "description must be between 5 and 1000 characters")
    private String description;

    @NotNull(message = "type is required")
    private ItemType type;

    @NotBlank(message = "category is required")
    @Size(max = 100, message = "category must be at most 100 characters")
    private String category;

    @NotBlank(message = "location is required")
    @Size(max = 255, message = "location must be at most 255 characters")
    private String location;

    private String imageUrl;

    public ItemCreateDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}