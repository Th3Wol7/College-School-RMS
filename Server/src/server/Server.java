package server;

import factories.DBConnectorFactory;
import factories.SessionFactoryBuilder;
import gui.*;
import model.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

public class Server {
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

                String clientConnected = "Clients connected: " + clientSocket.getInetAddress().getHostAddress() +
                        " @ " + localDateTime.format(dateTimeFormatter);

                // Displaying that new client is connected to server
                logger.info(clientConnected);

                // Update text area
                serverScreen.setTextArea(clientConnected);

                // create a new thread object
                ClientHandler clientHandler = new ClientHandler();

                // This thread will handle the client separately
                new Thread(clientHandler).start();
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

    ///////////Insert Queries////////////////
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

    public void addStudentGPA(StudentGPA studentGpa) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(studentGpa);
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

    public void addCourseGPA(CourseGPA courseGpa) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(courseGpa);
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

    //NTS: Come back to check this method
    public void addEnrollment(Student student) {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            for (Course courseCode : student.getEnrolledCourses()) {
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

    //////////////////////Update queries///////////////////

    public void updateUser(User user) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(user);
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

    public void updateStudent(Student student) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(student);
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

    public void updateStudentGPA(StudentGPA studentGpa) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(studentGpa);
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

    public void updateStaff(Staff staff) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(staff);
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

    public void updateProgramme(Programme programme) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(programme);
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

    public void updateCourse(Course course) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(course);
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

    public void updateAddress(Address address) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(address);
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

    public void updateCourseGPA(CourseGPA courseGpa) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(courseGpa);
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

    //NTS: Come back to check this method it's incorrect
    public void updateEnrollment(Student student) {
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

    ///////////////////Select Queries/////////////////////////

    private User getUser(String userID) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        User user = null;
        try {
            user = session.get(User.class, userID);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return user;
    }

    private Student getStudent(String studentID) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Student student = null;
        try {
            student = session.get(Student.class, studentID);
            transaction.commit();;
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return student;
    }

    private List<StudentGPA> getStudentGPA(String studentID, int year) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<StudentGPA> studentGPA = null;
        try {
            String hql = "FROM StudentGPA WHERE studentID = :studentID AND year = :year";
            Query query = session.createQuery(hql);
            query.setParameter("studentID", studentID);
            query.setParameter("year", year);
            studentGPA = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return studentGPA;
    }

    private Staff getStaff(String staffID) throws IOException {
        Staff staff = null;
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            staff = session.get(Staff.class, staffID);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return staff;
    }

    private Programme getProgramme(String programmeCode) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Programme programme = null;
        try {
            programme =  session.get(Programme.class, programmeCode);;
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return programme;
    }

    private Course getCourse(String courseCode) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Course course = null;
        try {
            course =  session.get(Course.class, courseCode);;
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return course;
    }

    private List<CourseGPA> getCourseGPA(String studentID, String courseID) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<CourseGPA> courseGPA = null;
        try {
            String hql = "FROM CourseGPA WHERE studentID = :studentID AND courseID = :courseID";
            Query query = session.createQuery(hql);
            query.setParameter("studentID", studentID);
            query.setParameter("courseID", courseID);
            courseGPA = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return courseGPA;
    }

    private Address getAddress(int addressID) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Address address = null;
        try {
            address = session.get(Address.class, addressID);;
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return address;
    }

    /*/NTS: Come back to check this method it's incorrect
    private Enrollment getEnrollment(int enrollmentID) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Enrollment enrollment = null;
        try {
            enrollment = session.get(Address.class,enrollmentID);;
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return enrollment;
    }*/


    /////////////////////////Select All Queries////////////
    private List<User> getAllUsers() throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<User> userList = null;
        try {
            userList = (List<User>) session.createQuery("FROM User").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return userList;
    }

    private List<Student> getAllStudents() throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Student> studentList = null;
        try {
            studentList = (List<Student>) session.createQuery("FROM Student").getResultList();
            transaction.commit();;
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return studentList;
    }

    private List<StudentGPA> getAllStudentGPA() throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<StudentGPA> studentGPAList = null;
        try {
            studentGPAList = (List<StudentGPA>) session.createQuery("FROM StudentGPA").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return studentGPAList;
    }

    private List<Staff> getAllStaff() throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Staff> staffList = null;
        try {
            staffList = (List<Staff>) session.createQuery("FROM Staff").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return staffList;
    }

    private List<Programme> getAllProgrammes() throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Programme> programmeList = null;
        try {
            programmeList = (List<Programme>) session.createQuery("FROM Programme").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return programmeList;
    }

    private List<Course> getAllCourses() throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Course> courseList = null;
        try {
            courseList = (List<Course>) session.createQuery("FROM Course").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return courseList;
    }

    private List<CourseGPA> getAllCourseGPA() throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<CourseGPA> courseGPAList = null;
        try {
            courseGPAList = (List<CourseGPA>) session.createQuery("FROM CourseGPA").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return courseGPAList;
    }

    private List<Address> getAllAddress() throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Address> addressList = null;
        try {
            addressList = (List<Address>) session.createQuery("FROM Address").getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("HibernateException: " + e.getMessage());
            transaction.rollback();
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
        return addressList;
    }

    ///////////////////Remove Queries/////////////////////////

    public void removeUser(String userID) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = session.get(User.class, userID);
            session.delete(user);
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

    public void removeStudent(String studentID) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Student student = session.get(Student.class, studentID);
            session.delete(student);
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

    public void removeStudentGPA(Long id) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            StudentGPA studentGPA = session.get(StudentGPA.class, id);
            session.delete(studentGPA);
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

    public void removeStaff(String staffID) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Staff staff = session.get(Staff.class, staffID);
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

    public void removeProgramme(String programmeCode) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Programme programme = session.get(Programme.class, programmeCode);
            session.delete(programme);
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

    public void removeCourse(String courseCode) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Course course = session.get(Course.class, courseCode);
            session.delete(course);
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

    public void removeCourseGPA(Long id) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            CourseGPA courseGpa = session.get(CourseGPA.class, id);
            session.delete(courseGpa);
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

    public void removeAddress(int addressID) throws IOException {
        Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Address address = session.get(Address.class, addressID);
            session.delete(address);
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


    class ClientHandler implements Runnable {
        @Override
        public void run() {
            String action;
            User user;
            Student student;
            Course course;
            Staff staff;
            StudentGPA studentGPA;
            CourseGPA courseGPA;
            Programme programme;
            Address address;
            configureStreams();
            try {
                action = (String) objIs.readObject();
                logger.info("Requested action: " + action);
                ServerScreen.setRequestsText(requestAmount++);
                ServerScreen.setTextArea("\nRequested action: " + action);
                ServerScreen.setTextArea("\nHandled on: " + Thread.currentThread().getName() + "\n\n");
                if (action.equals("Add user")) {
                    user = (User) objIs.readObject();
                    addUser(user);
                }
                if (action.equals("Update user")) {
                    user = (User) objIs.readObject();
                    updateUser(user);
                }
                if (action.equals("View students")) {
                    List<User> userList = getAllUsers();
                    for (User users : userList) {
                        objOs.writeObject(users);
                    }
                }
                if (action.equals("Find user")) {
                    String userID = (String) objIs.readObject();
                    user = getUser(userID);
                    objOs.writeObject(user);
                }
                if (action.equals("Remove user")) {
                    String userID = (String) objIs.readObject();
                    removeStudent(userID);
                }
                if (action.equals("Add Student")) {
                    student = (Student) objIs.readObject();
                    addStudent(student);
                }
                if (action.equals("Update student")) {
                    student = (Student) objIs.readObject();
                    updateStudent(student);
                }
                if (action.equals("View students")) {
                    List<Student> studentList = getAllStudents();
                    for (Student students : studentList) {
                        objOs.writeObject(students);
                    }
                }
                if (action.equals("Find student")) {
                    String studentId = (String) objIs.readObject();
                    student = getStudent(studentId);
                    objOs.writeObject(student);
                }
                if (action.equals("Remove student")) {
                    String studentId = (String) objIs.readObject();
                    removeStudent(studentId);
                }
                if (action.equals("Add studentGPA")) {
                    studentGPA = (StudentGPA) objIs.readObject();
                    addStudentGPA(studentGPA);
                }
                if (action.equals("View studentGPAs")) {
                    List<StudentGPA> StudentGPAList = getAllStudentGPA();
                    for (StudentGPA sGPA : StudentGPAList) {
                        objOs.writeObject(sGPA);
                    }
                }
                if (action.equals("Find studentGPA")) {
                    String studentID = (String) objIs.readObject();
                    int year = (int) objIs.readObject();
                    List<StudentGPA> studentGPAList = getStudentGPA(studentID, year);
                    objOs.writeObject(studentGPAList);
                }
                if (action.equals("Remove studentGPA")) {
                    Long studentGPANum = (Long) objIs.readObject();
                    removeStudentGPA(studentGPANum);
                }
                if (action.equals("Add Staff")) {
                    staff = (Staff) objIs.readObject();
                    addStaff(staff);
                }
                if (action.equals("Update Staff")) {
                    staff = (Staff) objIs.readObject();
                    updateStaff(staff);
                }
                if (action.equals("View Staffs")) {
                    List<Staff> StaffList = getAllStaff();
                    for (Staff stf : StaffList) {
                        objOs.writeObject(stf);
                    }
                }
                if (action.equals("Find Staff")) {
                    String StaffId = (String) objIs.readObject();
                    staff = getStaff(StaffId);
                    objOs.writeObject(staff);
                }
                if (action.equals("Remove Staff")) {
                    String StaffId = (String) objIs.readObject();
                    removeStaff(StaffId);
                }
                if (action.equals("Add Course")) {
                    course = (Course) objIs.readObject();
                    addCourse(course);
                }
                if (action.equals("Update Course")) {
                    course = (Course) objIs.readObject();
                    updateCourse(course);
                }
                if (action.equals("Find Course")) {
                    String courseCode = (String) objIs.readObject();
                    course = getCourse(courseCode);
                    objOs.writeObject(course);
                }
                if (action.equals("Remove Course")) {
                    String courseCode = (String) objIs.readObject();
                    removeCourse(courseCode);
                }
                if (action.equals("View Courses")) {
                    List<Course> CourseList = getAllCourses();
                    for (Course crse : CourseList) {
                        objOs.writeObject(crse);
                    }
                }
                if (action.equals("Add CourseGPA")) {
                    courseGPA = (CourseGPA) objIs.readObject();
                    addCourseGPA(courseGPA);
                }
                if (action.equals("View CourseGPAs")) {
                    List<CourseGPA> CourseGPAList = getAllCourseGPA();
                    for (CourseGPA cGPA : CourseGPAList) {
                        objOs.writeObject(cGPA);
                    }
                }
                if (action.equals("Find CourseGPA")) {
                    String studentID = (String) objIs.readObject();
                    String courseCode = (String) objIs.readObject();
                    List<CourseGPA> courseGPAList = getCourseGPA(studentID, courseCode);
                    objOs.writeObject(courseGPAList);
                }
                if (action.equals("Remove CourseGPA")) {
                    Long CourseGPANum = (Long) objIs.readObject();
                    removeCourseGPA(CourseGPANum);
                }
                if (action.equals("Add Programme")) {
                    programme = (Programme) objIs.readObject();
                    addProgramme(programme);
                }
                if (action.equals("Update Programme")) {
                    programme = (Programme) objIs.readObject();
                    updateProgramme(programme);
                }
                if (action.equals("Find Programme")) {
                    String programmeCode = (String) objIs.readObject();
                    programme = getProgramme(programmeCode);
                    objOs.writeObject(programme);
                }
                if (action.equals("Remove Programme")) {
                    String programmeCode = (String) objIs.readObject();
                    removeCourse(programmeCode);
                }
                if (action.equals("View Programme")) {
                    List<Programme> ProgrammeList = getAllProgrammes();
                    for (Programme program : ProgrammeList) {
                        objOs.writeObject(program);
                    }
                }
                if (action.equals("Add Address")) {
                    address = (Address) objIs.readObject();
                    addAddress(address);
                }
                if (action.equals("Update Address")) {
                    address = (Address) objIs.readObject();
                    updateAddress(address);
                }
                if (action.equals("Find Address")) {
                    int addressID = (int) objIs.readObject();
                    address = getAddress(addressID);
                    objOs.writeObject(address);
                }
                if (action.equals("Remove Address")) {
                    int addressID = (int) objIs.readObject();
                    removeAddress(addressID);
                }
                if (action.equals("View Address")) {
                    List<Address> AddressList = getAllAddress();
                    for (Address adrs : AddressList) {
                        objOs.writeObject(adrs);
                    }
                }
            } catch (IOException e) {
                logger.error("IOException: " + e.getMessage());
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                logger.error("ClassNotFoundException: " + e.getMessage());
                e.printStackTrace();
            } catch (ClassCastException e) {
                logger.error("ClassCastException: " + e.getMessage());
                e.printStackTrace();
            } finally {
                closeConnections();
            }
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
