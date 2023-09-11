package server;

import factories.DBConnectorFactory;
import factories.SessionFactoryBuilder;
import model.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import gui.*;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static factories.DBConnectorFactory.logger;


/*The purpose of this class is to receive, process and respond to requests from the server*/

public class Server{
    private static final Logger logger = LogManager.getLogger(Server.class);
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
    private final StartupScreen startupScreen = new StartupScreen();
    private ServerScreen serverScreen;
    private int requestAmount = 1;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectOutputStream objOs;
    private ObjectInputStream objIs;

    public Server() {
        createConnection();
        DBConnectorFactory.getDatabaseConnection();
        waitForRequests();
    }
    private void createConnection() {
        try {
            serverSocket = new ServerSocket(8888);
            serverSocket.setReuseAddress(true);
        } catch (IOException e) {
            logger.error("IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void configureStreams() {
        try {
            objOs = new ObjectOutputStream(clientSocket.getOutputStream());
            objIs = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            logger.error("IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void closeConnections() {
        try {
            objOs.close();
            objIs.close();
            clientSocket.close();
        } catch (IOException e) {
            logger.error("IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void waitForRequests() {
        serverScreen = new ServerScreen(serverSocket);
       startupScreen.dispose();
       serverScreen.setVisible(true);
        logger.info("Sever is running");
        try {
            // running infinite loop for getting client request
            while (true) {
                // get current local time
                LocalDateTime localDateTime = LocalDateTime.now();

                // socket object to receive incoming clientSocket requests
                clientSocket = serverSocket.accept();

                String clientConnected = "Client connected: " + clientSocket.getInetAddress().getHostAddress() +
                        " @ " + localDateTime.format(dateTimeFormatter);

                // Displaying that new client is connected to server
                logger.info(clientConnected);

                // Update text area
                serverScreen.setTextArea(clientConnected);

                // create a new thread object
                 //ClientHandler clientHandler = new ClientHandler();

                // This thread will handle the client separately
               // new Thread(clientHandler).start();
            }
        } catch (SocketException e) {
            logger.warn("SocketException: " + e.getMessage());
        } catch (IOException e) {
            logger.warn("IOException: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                logger.error("IOException: " + e.getMessage());
            }
        }
    }

    /**
     * Insert queries
     **/
    public void addUser(User user) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
            objOs.writeObject(true);
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
            e.printStackTrace();
            objOs.writeObject(false);
        } catch (IOException e) {
            transaction.rollback();
            logger.error("IOException: " + e.getMessage());
            e.printStackTrace();
            objOs.writeObject(false);
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
            objOs.writeObject(false);
        } finally {
            session.close();
        }
    }

    public void addStudent(Student student) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(student);
            transaction.commit();
            objOs.writeObject(true);
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
            e.printStackTrace();
            objOs.writeObject(false);
        } catch (IOException e) {
            transaction.rollback();
            logger.error("IOException: " + e.getMessage());
            e.printStackTrace();
            objOs.writeObject(false);
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
            objOs.writeObject(false);
        } finally {
            session.close();
        }
    }

    public void addStaff(Staff staff) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(staff);
            transaction.commit();
            objOs.writeObject(true);
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
            e.printStackTrace();
            objOs.writeObject(false);
        } catch (IOException e) {
            transaction.rollback();
            logger.error("IOException: " + e.getMessage());
            e.printStackTrace();
            objOs.writeObject(false);
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
            objOs.writeObject(false);
        } finally {
            session.close();
        }
    }

    public void addProgramme(Programme programme) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(programme);
            transaction.commit();
            objOs.writeObject(true);
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
            e.printStackTrace();
            objOs.writeObject(false);
        } catch (IOException e) {
            transaction.rollback();
            logger.error("IOException: " + e.getMessage());
            e.printStackTrace();
            objOs.writeObject(false);
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
            objOs.writeObject(false);
        } finally {
            session.close();
        }
    }

    public void addCourse(Course course) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(course);
            transaction.commit();
            objOs.writeObject(true);
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
            e.printStackTrace();
            objOs.writeObject(false);
        } catch (IOException e) {
            transaction.rollback();
            logger.error("IOException: " + e.getMessage());
            e.printStackTrace();
            objOs.writeObject(false);
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
            objOs.writeObject(false);
        } finally {
            session.close();
        }
    }


    public void addAddress(Address address) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(address);
            transaction.commit();
            objOs.writeObject(true);
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
            e.printStackTrace();
            objOs.writeObject(false);
        } catch (IOException e) {
            transaction.rollback();
            logger.error("IOException: " + e.getMessage());
            e.printStackTrace();
            objOs.writeObject(false);
        } catch (Exception e) {
            transaction.rollback();
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
            objOs.writeObject(false);
        } finally {
            session.close();
        }
    }

    public void addEnrollment(Student student) {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            for(Course courseCode: student.getEnrolledCourses()) {
                String sql = "INSERT INTO Enrolled (studentID, courseCode, programmeCode) VALUES (:studentID, :courseCode, :programmeCode)";
                session.createNativeQuery(sql)
                        .setParameter("studentID", student.getStudentID())
                        .setParameter("courseCode", courseCode)
                        .setParameter("programmeCode", student.getProgrammeCode())
                        .executeUpdate();

                transaction.commit();
            }
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
            e.printStackTrace();
        }
    }


}


/*
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class Server {///NTS: Revisit all operations method
    private static Connection dBConn = null;
    private ServerSocket serverSocket;
    private Socket connectionSocket;
    private ObjectOutputStream objOs;
    private ObjectInputStream objIs;
    private Statement stmt;
    private ResultSet result = null;

    //Default constructor
    public Server() {
        this.createConnection();
        this.waitForRequest();
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
        String sql = "INSERT INTO lab7bd.`students` (id, firstName, lastName, day, month,year, streetNum, streetName, " +
                "State, Country, telephone, dateEnrolled, programme, Status;)" + "VALUES ('" + student.getStudentID()
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
*/