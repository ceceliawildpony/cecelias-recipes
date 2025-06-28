package com.cecelia.favoriterecipes.repository;

import com.cecelia.favoriterecipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
