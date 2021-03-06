package de.hska.vs.categoryms.rest;

import de.hska.vs.categoryms.database.entity.CategoryEntity;
import de.hska.vs.categoryms.service.CategoryService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("")
public class RestCategoryController {

    private final CategoryService categoryService;

    public RestCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/category/{id}")
    public ResponseEntity<CategoryEntity> getCategory(@PathVariable int id) {
        Optional<CategoryEntity> result = categoryService.getCategory(id);
        return ResponseEntity.of(result);
    }

    @GetMapping(value = "/category")
    public List<CategoryEntity> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping(value = "/category?name={name}")
    public ResponseEntity<CategoryEntity> getByName(@PathVariable String name) {
        return ResponseEntity.of(categoryService.getCategory(name));
    }

    @DeleteMapping(value = "/category/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (categoryService.deleteCategory(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/category")
    public ResponseEntity<CategoryEntity> create(@RequestBody String name) {
        System.out.println("Creating new category with name " + name);
        return ResponseEntity.of(categoryService.createCategory(new CategoryEntity(name)));
    }

    @PostMapping(value = "/category/{id}")
    public void update(@PathVariable int id, @RequestBody String name) {
        categoryService.updateCategory(new CategoryEntity(id, name));
    }
}
