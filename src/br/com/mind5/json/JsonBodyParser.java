package br.com.mind5.json;

import java.util.List;

public interface JsonBodyParser<T> {
	public List<T> parse(String incomingData);
}
