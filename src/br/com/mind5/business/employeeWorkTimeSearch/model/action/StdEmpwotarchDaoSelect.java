package br.com.mind5.business.employeeWorkTimeSearch.model.action;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwotarchDaoSelect extends ActionStdTemplateV2<EmpwotarchInfo> {

	public StdEmpwotarchDaoSelect(DeciTreeOption<EmpwotarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmpwotarchInfo> buildVisitorHook(DeciTreeOption<EmpwotarchInfo> option) {
		return new VisiEmpwotarchDaoSelect(option);
	}
}
