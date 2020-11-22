package br.com.mind5.business.employee.model.action;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpSuccess extends ActionStdSuccessTemplate<EmpInfo> {
	
	public StdEmpSuccess(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
}
