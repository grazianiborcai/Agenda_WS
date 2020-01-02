package br.com.mind5.info.temp;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public interface InfoPrunerV2<T extends InfoRecord, S extends InfoRecord> {
	public List<T> prune();
}
