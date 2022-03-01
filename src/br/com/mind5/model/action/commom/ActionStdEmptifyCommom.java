package br.com.mind5.model.action.commom;

import br.com.mind5.info.InfoRecord;

public class ActionStdEmptifyCommom<T extends InfoRecord> extends ActionStdSuccessTemplate<T> {
	
	public ActionStdEmptifyCommom(Class<T> clazz) {
		super(clazz);
	}
}
