package spittr.data;

import org.springframework.jdbc.core.JdbcTemplate;
import spittr.Spitter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSpitterRepository implements SpitterRepository {

	private JdbcTemplate jdbcTemplate;


	public JdbcSpitterRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Spitter save(Spitter spitter) {
		return null;
	}

	@Override
	public Spitter findByUsername(String username) {
		return jdbcTemplate.queryForObject("SELECT * FROM Spitters WHERE Username=?", (resultSet, i) -> {return mapSpitter(resultSet);}, username);
	}

	private Spitter mapSpitter(ResultSet rs) throws SQLException {
		return new Spitter(
				rs.getLong("id"),
				rs.getString("Username"),
				rs.getString("Password"),
				rs.getString("FirstName"),
				rs.getString("LastName")
		);
	}
}
