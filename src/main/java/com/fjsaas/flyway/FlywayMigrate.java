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

	private String url;
	private String password;
	private String username;

	public void migrate() throws Exception {
		StringBuilder sb = new StringBuilder(url);
		Pattern pattern = Pattern.compile("^\\w+:\\w+:\\/{2}\\w+:\\d+\\/");
		Matcher matcher = pattern.matcher(sb);
		String jdbcStr = "";
		String schema = "";
		if (matcher.find()) {
			jdbcStr = matcher.group(0);
			schema = sb.toString().substring(jdbcStr.length()).split("\\?")[0];
		}

		if (StringUtils.isEmpty(jdbcStr) || StringUtils.isEmpty(schema)) {
			throw new RuntimeException("JDBC连接字符串有误，解析错误，请检查！");
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
