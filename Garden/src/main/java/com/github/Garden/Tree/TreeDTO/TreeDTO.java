package com.github.Garden.Tree.TreeDTO;

import com.github.Garden.Tree.LeafType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record TreeDTO(@NotNull(message = "field specie is mandatory.")
                      @NotBlank(message = "field specie is mandatory and can not be empty")
                      String specie,

                      @NotNull(message = "field height is mandatory.")
                      Integer height,

                      @NotNull(message = "field age is mandatory.")
                      Integer age,

                      @NotNull(message = "field leaf type is mandatory.")
                      LeafType leafType) {

}
