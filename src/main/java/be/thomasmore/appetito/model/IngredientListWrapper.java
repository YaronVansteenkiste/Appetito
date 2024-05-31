package be.thomasmore.appetito.model;

import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

import java.util.List;


    public class IngredientListWrapper {

        private List<Ingredient> ingredients;
        private List<MultipartFile> imageFiles;
        public IngredientListWrapper() {
            ingredients = new ArrayList<>();
            imageFiles = new ArrayList<>();
        }

        public List<Ingredient> getIngredients() {
            return ingredients;
        }

        public void setIngredients(List<Ingredient> ingredients) {
            this.ingredients = ingredients;
        }

        public List<MultipartFile> getImageFiles() {
            return imageFiles;
        }

        public void setImageFiles(List<MultipartFile> imageFiles) {
            this.imageFiles = imageFiles;
        }
}
