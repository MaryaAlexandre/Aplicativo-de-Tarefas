import java.util.Scanner;

public class TaskApp {
    private static Scanner scanner = new Scanner(System.in);
    private static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("Saindo do aplicativo...");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n===== Aplicativo de Gerenciamento de Tarefas =====");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Marcar Tarefa como Concluída");
        System.out.println("4. Remover Tarefa");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void addTask() {
        System.out.print("Digite a descrição da tarefa: ");
        String description = scanner.nextLine();
        Task task = new Task(description);
        taskManager.addTask(task);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void listTasks() {
        System.out.println("\nTarefas:");
        List<Task> tasks = taskManager.getAllTasks();
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void markTaskAsCompleted() {
        listTasks();
        System.out.print("Digite o número da tarefa a ser marcada como concluída: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        taskManager.markTaskAsCompleted(index);
        System.out.println("Tarefa marcada como concluída!");
    }

    private static void removeTask() {
        listTasks();
        System.out.print("Digite o número da tarefa a ser removida: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        taskManager.removeTask(index);
        System.out.println("Tarefa removida com sucesso!");
    }
}
