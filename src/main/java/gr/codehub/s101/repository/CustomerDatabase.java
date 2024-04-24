package gr.codehub.s101.repository;

import gr.codehub.s101.domain.Employee;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class CustomerDatabase {

    private static Logger logger = LoggerFactory.getLogger(CustomerDatabase.class);

    private static Server server = null;
    private static Connection connection;

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:mem:employee;DB_CLOSE_DELAY=-1;CASE_INSENSITIVE_IDENTIFIERS=TRUE";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    public CustomerDatabase() throws SQLException {
        logger.info("***************** Constructed new Customer Database ********************");
        getConnection();
        createTables();
    }

    public Connection getConnection() throws SQLException {
        if (server == null) {
            server = Server.createTcpServer("-tcpAllowOthers", "-tcpDaemon");
            server.start();
            logger.info("H2 server has started with status '{}'.", server.getStatus());
            org.h2.Driver.load();
            logger.info("H2 JDBC driver server has been successfully loaded.");
        } else {
            logger.info("H2 JDBC server is already running");
        }
        if (connection == null) {
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                DatabaseMetaData dm = connection.getMetaData();
                logger.info("Connected to database");
                logger.info("Product name=" + dm.getDatabaseProductName());
                logger.info("Product version=" + dm.getDatabaseProductVersion());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    static void createTables() throws SQLException {
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate("CREATE TABLE IF NOT EXISTS Employee (" +
                                             " id INTEGER PRIMARY KEY, " + // H2
                                             " name VARCHAR(100), " +
                                             " since INTEGER, " +
                                             " salary DECIMAL(10, 2) " +
                                             ");"
        );
        logger.info("Created table command was successful with result {}.", result);

        if (result == 0) {
            int rowsAffected = 0;
            rowsAffected += statement.executeUpdate("INSERT INTO employee (id, name, since, salary) VALUES (1, 'John Brown', 2018, 50000.00)");
            rowsAffected += statement.executeUpdate("INSERT INTO employee (id, name, since, salary) VALUES (2, 'Jane Smith', 2005, 60000.00)");
            rowsAffected += statement.executeUpdate("INSERT INTO employee (id, name, since, salary) VALUES (3, 'Michael Johnson', 2013, 55000.00)");
            logger.info("Employee table update command was successful with {} row(s) affected.", rowsAffected);
        }
    }


    public Employee getEmployee(int id) throws Exception {
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee WHERE id=" + id);
        Employee e = null;
        while(resultSet.next()) {
            e = new Employee();
            e.setId(resultSet.getInt("id"));
            e.setName(resultSet.getString("name"));
            e.setSince(resultSet.getInt("since"));
            e.setSalary(resultSet.getDouble("salary"));
            break;
        }
        return e;
    }

}
