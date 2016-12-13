package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.Spittle;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Repository
public class InMemorySpittleRepository implements SpittleRepository {

	private List<Spittle> spittles;

	public InMemorySpittleRepository() {
		this.spittles = new LinkedList<>();
	}

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		return spittles;
	}

	@Override
	public Spittle findOne(long id) {
		for (Spittle s : spittles)
		{
			if (Long.valueOf(id).equals(s.getId())) return s;
		}
		return null;
	}
}
