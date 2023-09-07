package factories;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//NTS: CREATE METHODS INCOMPLETE - Create table queries
public class DBConnectorFactory {

    private static final Logger logger = LogManager.getLogger(DBConnectorFactory.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection dbConn = null;

    public static Connection getDatabaseConnection() {
        if (dbConn != null) {
            return dbConn;
        }
        if (dbConn == null) {
            try {
                dbConn = DriverManager.getConnection(URL, USER, PASSWORD);
                if (dbConn != null) {
                    JOptionPane.showMessageDialog(null, "Connected to local server", "Home & Away Connection Status",
                            JOptionPane.INFORMATION_MESSAGE);
                    LocalDateTime localDateTime = LocalDateTime.now();
                    logger.info("DB Connection Established @ " + localDateTime.format(dateTimeFormatter));
                    //Auto creating database and it's tables once a successful connection has been established
                    createAddressTable();
                    createCourseTable();
                    createDateTable();
                    createProgrammeTable();
                    createStaffTable();
                    createStudentTable();
                    createTelephoneTable();
                    createUserTable();
                    createEnrollTable();
                }
            } catch (SQLException e) {
                System.err.println("Connection Failed: " + e.getMessage());

                logger.warn("SQLException: " + e.getMessage());
                boolean retry;
                int selection = JOptionPane.showConfirmDialog(
                        null,
                        "Could not connect to database H&AY." +
                                "\n" + e.getMessage() +
                                "\nRetry?",
                        "Connection Failure",
                        JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE
                );
                retry = (selection == JOptionPane.YES_OPTION);
                if (retry) {
                    logger.info("Attempting to establish connection...");
                    createHAYDatabase();
                    getDatabaseConnection();
                } else {
                    System.exit(0);
                }
            } catch (Exception e) {
                logger.error("Unexpected error: " + e.getMessage());
                System.err.println("Connection Failed: " + e.getMessage());
                e.printStackTrace();
            }

        }
        return dbConn;
    }

    private static void createUserTable() {
        try (Statement stmt = dbConn.createStatement()) {
            String query = "CREATE TABLE users(ID varchar(10) NOT NULL, firstName varchar(25)," +
                    "lastName varchar(25), dob date, password varchar(25)" +
                    ", userType varchar(15), PRIMARY KEY(ID))";
            if (stmt.executeUpdate(query) == 0) {
                logger.info("User table successfully created.");
            }
        } catch (SQLException e) {
            logger.warn("SQLException: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createTelephoneTable() {
        try (Statement stmt = dbConn.createStatement()) {
            String query = "CREATE TABLE telephone(ID varchar(10) NOT NULL, telephone varchar(20), " +
                    "PRIMARY KEY(ID))";

            if (stmt.executeUpdate(query) == 0) {
                logger.info("Telephone table successfully created.");
            }
        } catch (SQLException e) {
            logger.warn("SQLException: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createStudentTable() {
        try (Statement stmt = dbConn.createStatement()) {
            String query = "CREATE TABLE student(ID varchar(10) NOT NULL, firstName varchar(25)," +
                    "lastName varchar(25), dob date, email varchar(30) UNIQUE, programmeCode varchar(15), " +
                    "enrollmentStatus varchar(15), PRIMARY KEY(ID), " +
                    "FOREIGN KEY(programmeCode) REFERENCES programmes(programmeCode))";

            if (stmt.executeUpdate(query) == 0) {
                logger.info("Student table successfully created.");
            }
        } catch (SQLException e) {
            logger.warn("SQLException: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createStaffTable() {
        try (Statement stmt = dbConn.createStatement()) {
            String query = "CREATE TABLE staff(ID varchar(10) NOT NULL, firstName varchar(25), " +
                    "lastName varchar(25), dob date, email varchar(30) UNIQUE, faculty varchar(30)," +
                    " department varchar(30), dateEmployed date)";

            if (stmt.executeUpdate(query) == 0) {
                logger.info("Staff table successfully created.");
            }
        } catch (SQLException e) {
            logger.warn("SQLException: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createProgrammeTable() {
        try (Statement stmt = dbConn.createStatement()) {
            String query = "CREATE TABLE programmes(programmeCode varchar(10) NOT NULL, programmeName varchar(35), " +
                    "accreditation varchar(25), numOfCourses int, yearsOfStudy int, " +
                    "Description varchar(100), cost decimal(10,2), totalCredits int, PRIMARY KEY(programmeCode))";

            if (stmt.executeUpdate(query) == 0) {
                logger.info("Programme table successfully created.");
            }
        } catch (SQLException e) {
            logger.warn("SQLException: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createDateTable() {
        try (Statement stmt = dbConn.createStatement()) {
            String query = "";

            if (stmt.executeUpdate(query) == 0) {
                logger.info("Date table successfully created.");
            }
        } catch (SQLException e) {
            logger.warn("SQLException: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createCourseTable() {
        try (Statement stmt = dbConn.createStatement()) {
            String query = "CREATE TABLE courses(courseCode varchar(10), courseName varchar(35)," +
                    "description varchar(80), credits int, prerequisite varchar(15), " +
                    "PRIMARY KEY (courseCode), FOREIGN KEY(prequisite) REFERENCES courses(courseCode))";

            if (stmt.executeUpdate(query) == 0) {
                logger.info("Course table successfully created.");
            }
        } catch (SQLException e) {
            logger.warn("SQLException: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createEnrollTable() {
        try (Statement stmt = dbConn.createStatement()) {
            String query = "CREATE TABLE enrolled(studentID varchar(10) NOT NULL, courseCode varchar(10) NOT NULL, " +
                    "programmeCode varchar(10) NOT NULL, PRIMARY KEY (studentID, courseCode), " +
                    "FOREIGN KEY studentID REFERENCES students(studentID), FOREIGN KEY courseCode " +
                    "REFERENCES courses(CourseCode), FOREIGN KEY programmeCode REFERENCES programmes(programmeCode))";

            if (stmt.executeUpdate(query) == 0) {
                logger.info("Enrol table successfully created.");
            }
        } catch (SQLException e) {
            logger.warn("SQLException: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createAddressTable() {
        try (Statement stmt = dbConn.createStatement()) {
            String query = "CREATE TABLE addresses(ID varchar(10) NOT NULL, streetAddress varchar(80), " +
                    "zipCode varchar(10), country(30), PRIMARY KEY(ID))";

            if (stmt.executeUpdate(query) == 0) {
                logger.info("Address table successfully created.");
            }
        } catch (SQLException e) {
            logger.warn("SQLException: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createHAYDatabase() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()
        ) {
            String query = "CREATE DATABASE IF NOT EXISTS H&AY";
            if (stmt.executeUpdate(query) == 0) {
                logger.info("H&AY Database created");
                System.out.println("H&AY Database created");
            }
        } catch (SQLException e) {
            logger.warn("SQLException: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

