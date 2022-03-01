package br.com.mind5.model.action.commom;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class ActionStdSuccessCommom<T extends InfoRecord> extends ActionStdSuccessTemplate<T> {
	
	public ActionStdSuccessCommom(DeciTreeOption<T> option) {
		super(option);
	}
}
