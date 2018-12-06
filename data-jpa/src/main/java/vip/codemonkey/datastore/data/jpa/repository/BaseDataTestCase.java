package vip.codemonkey.datastore.data.jpa.repository;

import org.dbunit.ant.Operation;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DefaultMetadataHandler;
import org.dbunit.database.ForwardOnlyResultSetTableFactory;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseDataTestCase {
    protected static final Logger logger = LoggerFactory.getLogger(BaseDataTestCase.class);

    @Autowired
    private Environment env;

    @PostConstruct
    public void postConstruct() throws Exception {
        importSampleData();
    }

    public void importSampleData() throws Exception {
        String datasourceUrl = env.getProperty("spring.datasource.url");
        logger.info("db unit url is {}",datasourceUrl);
        Connection conn = DriverManager.getConnection(datasourceUrl, env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"));
        DatabaseConnection connection = new DatabaseConnection(conn);
        DatabaseConfig config = connection.getConfig();
        config.setProperty(DatabaseConfig.PROPERTY_RESULTSET_TABLE_FACTORY,new ForwardOnlyResultSetTableFactory());
        config.setProperty(DatabaseConfig.FEATURE_CASE_SENSITIVE_TABLE_NAMES,false);
        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY,Class.forName(env.getProperty("spring.dbunit.data-factory")).newInstance());
        config.setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER,new DefaultMetadataHandler());

        Operation operation = new Operation();
        operation.setTransaction(true);
        operation.setType(env.getProperty("spring.dbunit.operationType"));
        operation.setFormat("flat");
        operation.setSrc(new File(env.getProperty("spring.dbunit.sample-file")));

        try{
            operation.execute(connection);
        }finally {
            connection.close();
        }
    }
}
