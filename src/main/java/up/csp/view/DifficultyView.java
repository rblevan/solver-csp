package up.csp.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.control.Button;


public class DifficultyView extends Application {

    private Button easy;
    private Button medium;
    private Button hard;

    @Override
    public void start(Stage stage) {

        Label title = new Label("Sudoku Solver by Les 5 Solvers.");
        Label label = new Label("Select Difficulty :");
        easy = new Button("easy");
        medium = new Button("medium");
        hard = new Button("hard");

        VBox root = new VBox(20);
        HBox buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);

        buttonBox.getChildren().addAll(easy, medium, hard);
        root.getChildren().addAll(title, label, buttonBox);

        Scene scene = new Scene(root, 700, 700);
        stage.setTitle("Select Difficulty");
        stage.setScene(scene);
        stage.show();

    }

    public Button getEasyButton() { return easy; }
    public Button getMediumButton() { return medium; }
    public Button getHardButton() { return hard; }

}
