package server;


import model.Student;

import java.awt.HeadlessException;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Server {///NTS: Revisit all operations method
    private ServerSocket serverSocket;
    private Socket connectionSocket;
    private ObjectOutputStream objOs;
    private ObjectInputStream objIs;
    private static Connection dBConn = null;
    private Statement stmt;
    private ResultSet result = null;

    //Default constructor
    public Server() {
        this.createConnection();
        this.waitForRequest();
    }

    private void createConnection() {
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void configureStream() {

        try {
            //Instantiate the output stream, using the getOutputStream method
            //of the Socket object as argument to the constructor
            objOs = new ObjectOutputStream(connectionSocket.getOutputStream());

            //Instantiate the input stream, using the outputStream method
            //of the socket object as argument to the constructor
            objIs = new ObjectInputStream(connectionSocket.getInputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private static Connection getDatabaseConnection() {

        try {
            String url = "jdbc:mysql://localhost:3306/lab7bd";
            dBConn = DriverManager.getConnection(url, "root", "");

            JOptionPane.showMessageDialog(null, "Database Connection Established", "Connection Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Could not connect to database\n" + e, "Connection Failure", JOptionPane.ERROR_MESSAGE);
        }

        return dBConn;
    }

    private void CloseConnection() {
        try {
            objOs.close();
            objIs.close();
            connectionSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Adding student to database

    private void addStudentToFile(Student student) {
        String sql = "INSERT INTO lab7bd.`students` (id, firstName, lastName, day, month,year, streetNum, streetName, State, Country, telephone, dateEnrolled, programme, Status;)" + "VALUES ('" + student.getId()
                + "', '" + student.getFirstName() + "', '" + student.getLastName() + "', '" + student.getDetails().getEmail()
                + "');";
        try {
            stmt = Server.getDatabaseConnection().createStatement();
            if (stmt.executeUpdate(sql) == 1) {
                objOs.writeObject(true); // return true to the client if successful
            } else {
                objOs.writeObject(false);
            }
        } catch (IOException ioe) {
            // Ideally you want to save errors to a log file
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void removeStudent(String id) {//Test this method
        String deleteStudent = "DELETE FROM lab7bd.students WHERE id ='" + id + "'";
        try {
            stmt = Server.getDatabaseConnection().createStatement();
            if (stmt.executeUpdate(deleteStudent) == 1) {
                objOs.writeObject(true); // return true to the client if successful
            } else {
                objOs.writeObject(false);
            }
        } catch (Exception e) {
            System.err.println("Error Deleting Record: " + e.getMessage());
        }
    }

    private void updateStudent(Student student) {//Test this method
        String updateSql = "UPDATE lab7bd.students SET firstName '" + student.getFirstName() +
                "' WHERE id = '" + student.getStudentID() + "'";
        try {
            stmt = Server.getDatabaseConnection().createStatement();
            if (stmt.executeUpdate(updateSql) == 1) {
                objOs.writeObject(true); // return true to the client if successful
            } else {
                objOs.writeObject(false);
            }
        } catch (Exception e) {
            System.err.println("Error updating Record: " + e.getMessage());
        }
    }


    // Searching database for student with retreived id
    private Student findStudentById(String stuId) {
        Student stuObj = new Student();
        String query = "SELECT * FROM lab7bd.students WHERE id = " + stuId;
        try {
            stmt = Server.getDatabaseConnection().createStatement();
            result = stmt.executeQuery(query);
            if (result.next()) {
                stuObj.setStudentID(result.getString(1));
                stuObj.setFirstName(result.getString(2));
                stuObj.setLastName(result.getString(3));
                stuObj.getDetails().setEmail(result.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stuObj;
    }

    private ArrayList<Student> readAll() {
        ArrayList<Student> studentList = new ArrayList<>();
        // Student stuObj = new Student();
        String query = "SELECT * FROM lab7bd.students";
        try {
            stmt = Server.getDatabaseConnection().createStatement();
            result = stmt.executeQuery(query);
            while (result.next()) {
                Student stuObj = new Student();
                stuObj.setStudentID(result.getString(1));
                stuObj.setFirstName(result.getString(2));
                stuObj.setLastName(result.getString(3));
                stuObj.getDetails().setEmail(result.getString(4));
                studentList.add(stuObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }


    private void waitForRequest() {
        String action = "";
        getDatabaseConnection();
        Student stuObj = null;
        try {
            while (true) {
                connectionSocket = serverSocket.accept();
                this.configureStream();
                try {
                    action = (String) objIs.readObject();

                    if (action.equalsIgnoreCase("Add Student")) {
                        stuObj = (Student) objIs.readObject();
                        addStudentToFile(stuObj);
                        objOs.writeObject(true);
                    } else if (action.equalsIgnoreCase("Find Student")) {
                        String stuId = (String) objIs.readObject();
                        //call method to find the student based on id number

                        stuObj = findStudentById(stuId);
                        objOs.writeObject(stuObj);
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (ClassCastException ex) {
                    ex.printStackTrace();
                }
                this.CloseConnection();
            }
        } catch (EOFException ex) {
            System.out.println("Client has terminated connections with the server");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
