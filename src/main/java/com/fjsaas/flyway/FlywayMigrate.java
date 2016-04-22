package com.fjsaas.flyway;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.junit.Test;
import org.springframework.util.StringUtils;

public class FlywayMigrate {

	private Properties properties = new Properties();

	private String dbPropUrl;
	private String jdbcUrlKey;
	private String usernameKey;
	private String passwordKey;

	public void setDbPropUrl(String dbPropUrl) {
		this.dbPropUrl = dbPropUrl;
	}

	public void setJdbcUrlKey(String jdbcUrlKey) {
		this.jdbcUrlKey = jdbcUrlKey;
	}

	public void setUsernameKey(String usernameKey) {
		this.usernameKey = usernameKey;
	}

	public void setPasswordKey(String passwordKey) {
		this.passwordKey = passwordKey;
	}

	public void init() throws IOException {
		InputStream in = FlywayMigrate.class.getResourceAsStream(dbPropUrl);
		properties.load(in);
		in.close();

	}

	public void migrate() throws Exception {
		init();

		String jdbcUrl = properties.getProperty(jdbcUrlKey);
		String username = properties.getProperty(usernameKey);
		String password = properties.getProperty(passwordKey);

		StringBuilder sb = new StringBuilder(jdbcUrl);
		Pattern pattern = Pattern.compile("^\\w+:\\w+:\\/{2}\\w+:\\d+\\/");
		Matcher matcher = pattern.matcher(sb);
		String jdbcStr = "";
		String schema = "";
		if (matcher.find()) {
			jdbcStr = matcher.group(0);
			schema = sb.toString().substring(jdbcStr.length()).split("\\?")[0];
		}

		if (StringUtils.isEmpty(jdbcStr) || StringUtils.isEmpty(schema)) {
			throw new RuntimeException(dbPropUrl + "中的jdbc.url有误.");
		}
		// Create the Flyway instance
		Flyway flyway = new Flyway();

		// Point it to the database
		flyway.setDataSource(jdbcStr, username, password);
		flyway.setSchemas(schema);
		flyway.setTable("schema_version");
		flyway.setLocations("classpath:db/migration"); 
		flyway.setEncoding("UTF-8"); 
		flyway.migrate();
	}

}
