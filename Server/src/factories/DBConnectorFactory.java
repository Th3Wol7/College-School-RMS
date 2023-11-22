package factories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DBConnectorFactory {
    public static final Logger logger = LogManager.getLogger(DBConnectorFactory.class);
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
                dbConn = DriverManager.getConnection(URL + "HaAy", USER, PASSWORD);
                if (dbConn != null) {
                    JOptionPane.showMessageDialog(null, "Connected to local server", "Home & Away Connection Status",
                            JOptionPane.INFORMATION_MESSAGE);
                    LocalDateTime localDateTime = LocalDateTime.now();
                    logger.info("DB Connection Established @ " + localDateTime.format(dateTimeFormatter));
                    //Auto creating database and it's tables once a successful connection has been established
                    createAddressTable();
                    createCourseTable();
                    createEnrollTable();
                    createProgrammeTable();
                    createStaffTable();
                    createStudentTable();
                    createTelephoneTable();
                    createUserTable();
                }
            } catch (SQLException e) {
                System.err.println("Connection Failed: " + e.getMessage());

                logger.warn("SQLException: " + e.getMessage());
                boolean retry;
                int selection = JOptionPane.showConfirmDialog(
                        null,
                        "Could not connect to database HaAy." +
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

    //Table creation methods
    private static void createAddressTable() {
        try (Statement stmt = dbConn.createStatement()) {
            String query = "CREATE TABLE Address(ID varchar(10) NOT NULL, streetAddress varchar(45)," +
                    "states varchar(25), zipCode varchar(10), country varchar(30), PRIMARY KEY(ID))";

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

    private static void createUserTable() {
        try (Statement stmt = dbConn.createStatement()) {
            String query = "CREATE TABLE User(ID varchar(10) NOT NULL, firstName varchar(25)," +
                    "lastName varchar(25), dob date, email varchar(30) UNIQUE, addressID varchar(10), password varchar(25)" +
                    ", userType varchar(15), PRIMARY KEY(ID), FOREIGN KEY(addressID) REFERENCES Address(ID))";
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
            String query = "CREATE TABLE Telephone(ID varchar(10) NOT NULL, telephone varchar(20), " +
                    "PRIMARY KEY(ID, telephone), FOREIGN KEY(ID) REFERENCES User(ID))";

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

    private static void createProgrammeTable() {
        try (Statement stmt = dbConn.createStatement()) {
            String query = "CREATE TABLE Programme(programmeCode varchar(10) NOT NULL, programmeName varchar(35), " +
                    "accreditation varchar(25), numOfCourses int, yearsOfStudy int, director varchar(10) " +
                    "description varchar(100), cost decimal(10,2), totalCredits int, PRIMARY KEY(programmeCode))";

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

    private static void createCourseTable() {
        try (Statement stmt = dbConn.createStatement()) {
            String query = "CREATE TABLE Course(courseCode varchar(10), courseName varchar(35), " +
                    "description varchar(80), credits int, prerequisite varchar(15), " +
                    "PRIMARY KEY (courseCode), FOREIGN KEY(prequisite) REFERENCES Course(courseCode))";

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
            String query = "CREATE TABLE Enrolled(studentID varchar(10) NOT NULL, courseCode varchar(10) NOT NULL, " +
                    "programmeCode varchar(10) NOT NULL, PRIMARY KEY (studentID, courseCode), " +
                    "FOREIGN KEY studentID REFERENCES Students(ID), FOREIGN KEY courseCode " +
                    "REFERENCES Course(CourseCode), FOREIGN KEY programmeCode REFERENCES Programme(programmeCode))";

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

    private static void createStudentTable() {
        try (Statement stmt = dbConn.createStatement()) {
            String query = "CREATE TABLE Student(ID varchar(10) NOT NULL, firstName varchar(25)," +
                    "lastName varchar(25), dob date, programmeCode varchar(15), " +
                    "enrollmentStatus varchar(15), dateEnrolled date, PRIMARY KEY(ID), " +
                    "FOREIGN KEY(programmeCode) REFERENCES Programmes(programmeCode) + " +
                    "FOREIGN KEY(ID) REFERENCES Users(ID)), FOREIGN KEY(firstName) REFERENCES User(firstName))" +
                    "FOREIGN KEY(lastName) REFERENCES User(lastName))";

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
            String query = "CREATE TABLE Staff(ID varchar(10) NOT NULL, firstName varchar(25), " +
                    "lastName varchar(25), dob date, email varchar(30) UNIQUE, faculty varchar(30), " +
                    "department varchar(30), occupation varchar(20), dateEmployed date, PRIMARY KEY (ID)" +
                    "FOREIGN KEY(department) REFERENCES Department(departmentCode)" +
                    "FOREIGN KEY(ID) REFERENCES User(ID)), FOREIGN KEY(firstName) REFERENCES User(firstName))" +
                    "FOREIGN KEY(lastName) REFERENCES User(lastName))";

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


    private static void createHAYDatabase() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()
        ) {
            String query = "CREATE DATABASE IF NOT EXISTS H&AY";
            if (stmt.executeUpdate(query) == 0) {
                logger.info("HaAy Database created");
                System.out.println("HaAy Database created");
            }
        } catch (SQLException e) {
            logger.warn("SQLException: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

