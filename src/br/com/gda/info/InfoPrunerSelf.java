package br.com.gda.info;

import java.util.List;

public interface InfoPrunerSelf<T extends InfoRecord> {
	
	public List<T> prune(List<T> source);
}
