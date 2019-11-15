package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmposSuccess extends ActionStdSuccessTemplate<EmposInfo> {
	public StdEmposSuccess(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
}
