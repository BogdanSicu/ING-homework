package ing.store_management.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(
        @NotNull(message = "Name can't be null")
        @NotEmpty(message = "Name can't be empty")
        String name,
        @Min(value = 0, message = "Price can't be lower than 0")
        float price,
        @Min(value = 1, message = "Quantity can't be lower than 1")
        long quantity) {
}
