package up.csp.controller;

import up.csp.model.DifficultyModel;
import up.csp.view.DifficultyView;

public class DifficultyController {

    private DifficultyModel model;
    private DifficultyView view;

    public DifficultyController(DifficultyModel model, DifficultyView view) {
        this.model = model;
        this.view = view;
        initListeners();
    }

    private void initListeners() {
        view.getEasyButton().setOnAction(e -> {
            model.setDifficulty("easy");
            System.out.println("Difficulté choisie : " + model.getDifficulty());
        });

        view.getMediumButton().setOnAction(e -> {
            model.setDifficulty("medium");
            System.out.println("Difficulté choisie : " + model.getDifficulty());
        });

        view.getHardButton().setOnAction(e -> {
            model.setDifficulty("hard");
            System.out.println("Difficulté choisie : " + model.getDifficulty());
        });
    }

    public void setDifficulty(String difficulty) {
        model.setDifficulty(difficulty);
    }

    public String getDifficulty() {
        return model.getDifficulty();
    }



}
