package br.com.mind5.info.temp;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public abstract class InfoPrunerV2<T extends InfoRecord, S extends InfoRecord> {
	
	public InfoPrunerV2() {
		
	}

	
	
	public abstract List<T> prune();
}
