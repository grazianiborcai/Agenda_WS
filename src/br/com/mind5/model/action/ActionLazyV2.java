package br.com.mind5.model.action;

import br.com.mind5.info.InfoRecord;

public interface ActionLazyV2<T extends InfoRecord> extends ActionLazyV1<T> { 
	
	public void close();
}
