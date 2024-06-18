package mid.app.midterm;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, Integer> studentNumberColumn;

    @FXML
    private TableColumn<Student, String> firstNameColumn;

    @FXML
    private TableColumn<Student, String> lastNameColumn;

    @FXML
    private TableColumn<Student, String> telephoneColumn;

    @FXML
    private TableColumn<Student, String> addressColumn;

    @FXML
    private TableColumn<Student, String> provinceColumn;

    @FXML
    private TableColumn<Student, Double> averageGradeColumn;

    @FXML
    private TableColumn<Student, String> majorColumn;

    public void initializeTableView() {
        // Initialize columns
        studentNumberColumn.setCellValueFactory(new PropertyValueFactory<>("studentNumber"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telephoneNumber"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        provinceColumn.setCellValueFactory(new PropertyValueFactory<>("province"));
        averageGradeColumn.setCellValueFactory(new PropertyValueFactory<>("averageGrade"));
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));

        // Populate TableView with 1000 Student objects from database
        List<Student> students = fetchStudentsFromDatabase();
        tableView.getItems().addAll(students);
    }

    private List<Student> fetchStudentsFromDatabase() {
        List<Student> students = new ArrayList<>();
        String url = "jdbc:mysql://database-1.czwi6oo0m60t.us-east-2.rds.amazonaws.com:3306/mobile_phone_db";
        String username = "admin";
        String password = "Behappy123";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM students LIMIT 1000";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int studentNumber = resultSet.getInt("student_number");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String telephoneNumber = resultSet.getString("telephone_number");
                String address = resultSet.getString("address");
                String province = resultSet.getString("province");
                double averageGrade = resultSet.getDouble("average_grade");
                String major = resultSet.getString("major");

                Student student = new Student(studentNumber, firstName, lastName, telephoneNumber,
                        address, province, averageGrade, major);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}
