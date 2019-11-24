package br.com.mind5.business.employeeWorkTime.model.action;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwotmSuccess extends ActionStdSuccessTemplate<EmpwotmInfo> {
	public StdEmpwotmSuccess(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
}
