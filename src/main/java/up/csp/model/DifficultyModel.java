package up.csp.model;

public class DifficultyModel {
    private String difficulty;

    public DifficultyModel(String difficulty) {
        setDifficulty(difficulty);
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
