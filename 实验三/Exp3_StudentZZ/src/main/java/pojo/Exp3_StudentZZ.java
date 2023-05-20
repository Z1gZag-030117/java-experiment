package pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Öì†´
 * @version 1.0
 */
public class Exp3_StudentZZ {
    private String id;
    private String name;
    private String grade;
    public Exp3_StudentZZ() {
    }
    public Exp3_StudentZZ(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
