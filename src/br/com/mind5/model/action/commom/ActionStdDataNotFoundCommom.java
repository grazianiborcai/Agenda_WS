package br.com.mind5.model.action.commom;

import br.com.mind5.common.SystemCode;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class ActionStdDataNotFoundCommom<T extends InfoRecord> extends ActionStdFailedTemplate<T> {
	
	public ActionStdDataNotFoundCommom(DeciTreeOption<T> option) {
		super(option, SystemCode.DATA_NOT_FOUND);
	}
}
