package br.com.gda.info;

import java.util.List;

public interface InfoUniquifier<T> {
	public List<T> uniquify(List<T> infoRecords);
}
