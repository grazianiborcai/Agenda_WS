package br.com.mind5.business.employeeList.model.action;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplisSuccess extends ActionStdSuccessTemplate<EmplisInfo> {
	public StdEmplisSuccess(DeciTreeOption<EmplisInfo> option) {
		super(option);
	}
}
