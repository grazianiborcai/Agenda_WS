package br.com.mind5.business.employeeWorkTimeRange.model.action;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpworgMergeToSelect extends ActionStdTemplateV2<EmpworgInfo> {

	public StdEmpworgMergeToSelect(DeciTreeOption<EmpworgInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmpworgInfo> buildVisitorHook(DeciTreeOption<EmpworgInfo> option) {
		return new VisiEmpworgMergeToSelect(option);
	}
}
