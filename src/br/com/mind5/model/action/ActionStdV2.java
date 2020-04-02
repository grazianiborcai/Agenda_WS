package br.com.mind5.model.action;

import br.com.mind5.info.InfoRecord;

public interface ActionStdV2<T extends InfoRecord> extends ActionStdV1<T>{
	
	public void close();
}
