package trening1.animals;

public class Food {
    private String foodDescription;
    private int foodAmount;
    private String foodType;

    public Food(String foodDescription, int foodAmount, String foodType) {
        this.foodDescription = foodDescription;
        this.foodAmount = foodAmount;
        this.foodType = foodType;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
}
