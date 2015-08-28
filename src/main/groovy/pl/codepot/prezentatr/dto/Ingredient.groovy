package pl.codepot.prezentatr.dto

class Ingredient {

    IngredientType type;
    Integer quantity;

    Ingredient(IngredientType type, Integer quantity) {
        this.type = type
        this.quantity = quantity
    }

    IngredientType getType() {
        return type
    }

    void setType(IngredientType type) {
        this.type = type
    }

    Integer getQuantity() {
        return quantity
    }

    void setQuantity(Integer quantity) {
        this.quantity = quantity
    }
}
