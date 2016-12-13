package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.Spitter;

import java.util.LinkedList;
import java.util.List;

@Repository
public class InMemorySpitterRepository implements SpitterRepository {

	private List<Spitter> spitters;

	public InMemorySpitterRepository() {
		spitters = new LinkedList<>();
	}

	@Override
	public Spitter save(Spitter spitter) {
		spitters.add(spitter);
		return spitter;
	}

	@Override
	public Spitter findByUsername(String username) {
		for (Spitter s : spitters) {
			if (username.equals(s.getUsername())) return s;
		}
		return null;
	}
}
