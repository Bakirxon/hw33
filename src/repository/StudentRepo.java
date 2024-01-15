package repository;

import entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements Repository<Student> {

    private static final String PATH = "src/repository/user_db.txt";
    private ArrayList<Student> students;
    private static StudentRepo singleton;

    private StudentRepo(ArrayList<Student> students) {
        this.students = students;
    }

    public static StudentRepo getInstance() throws IOException {
        if (singleton == null){
            singleton = new StudentRepo(loadData());
        }
        return singleton;
    }

    @SuppressWarnings("unchecked")
    private static ArrayList<Student> loadData() throws IOException {
        try(
                InputStream inputStream = new FileInputStream(PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ){
            return (ArrayList<Student>)objectInputStream.readObject();
        } catch (EOFException e){
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void uploadData() {
        try(
                OutputStream outputStream = new FileOutputStream(PATH);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        ) {
            objectOutputStream.writeObject(students);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void save(Student student) {
        students.add(student);
        uploadData();
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void delete(Student student) {

    }
}
