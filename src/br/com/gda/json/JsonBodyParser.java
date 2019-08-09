package br.com.gda.json;

import java.util.List;

public interface JsonBodyParser<T> {
	public List<T> parse(String incomingData);
}
