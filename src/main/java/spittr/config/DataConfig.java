package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import spittr.data.JdbcSpitterRepository;
import spittr.data.JdbcSpittleRepository;
import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;

import javax.sql.DataSource;

@Configuration
public class DataConfig {

	@Bean
	public DataSource dataSource() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return new DriverManagerDataSource(
				"jdbc:mysql://localhost:3306/spittr",
				"spittr",
				"change-me" // todo move password to some external config file
		);
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate) {
		return new JdbcSpitterRepository(jdbcTemplate);
	}

	@Bean
	public SpittleRepository spittleRepository(JdbcTemplate jdbcTemplate) {
		return new JdbcSpittleRepository(jdbcTemplate);
	}
}
