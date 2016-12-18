package spittr.data;

import org.springframework.jdbc.core.JdbcTemplate;
import spittr.Spitter;
import spittr.Spittle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcSpittleRepository implements SpittleRepository {

	private JdbcTemplate jdbcTemplate;


	public JdbcSpittleRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		return jdbcTemplate.query("SELECT * FROM Spittles WHERE id <= ? LIMIT ?", this::mapSpittle, max, count);
	}

	@Override
	public Spittle findOne(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM Spittles WHERE id = ?", this::mapSpittle, id);
	}

	private Spittle mapSpittle(ResultSet resultSet, int rowNumber) throws SQLException {
		return new Spittle(
				resultSet.getString("Message"),
				resultSet.getDate("Time"),
				resultSet.getDouble("Longitude"),
				resultSet.getDouble("Latitude")
		);
	}
}
