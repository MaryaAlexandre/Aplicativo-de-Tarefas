import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private ListView<String> taskList;
    private TextField taskField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Configurar a lista de tarefas
        taskList = new ListView<>();

        // Configurar o campo de texto para adicionar tarefas
        taskField = new TextField();
        taskField.setPromptText("Adicionar nova tarefa");

        // Configurar o botão para adicionar tarefas
        Button addButton = new Button("Adicionar");
        addButton.setOnAction(e -> addTask());

        // Configurar o botão para marcar tarefa como concluída
        Button markButton = new Button("Marcar como Concluída");
        markButton.setOnAction(e -> markTask());

        // Configurar o botão para remover tarefa
        Button removeButton = new Button("Remover Tarefa");
        removeButton.setOnAction(e -> removeTask());

        // Layout principal
        VBox layout = new VBox(10);
        layout.getChildren().addAll(taskList, taskField, addButton, markButton, removeButton);

        // Configurar a cena e exibir a janela
        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Gerenciador de Tarefas");
        stage.show();
    }

    // Método para adicionar uma nova tarefa à lista
    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            taskList.getItems().add(task);
            taskField.clear();
        }
    }

    // Método para marcar uma tarefa como concluída
    private void markTask() {
        int selectedIndex = taskList.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            String task = taskList.getItems().get(selectedIndex);
            taskList.getItems().set(selectedIndex, "✔️ " + task);
        }
    }

    // Método para remover uma tarefa da lista
    private void removeTask() {
        int selectedIndex = taskList.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            taskList.getItems().remove(selectedIndex);
        }
    }
}
