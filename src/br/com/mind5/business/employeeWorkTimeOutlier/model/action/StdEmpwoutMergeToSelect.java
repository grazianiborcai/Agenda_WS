package br.com.mind5.business.employeeWorkTimeOutlier.model.action;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwoutMergeToSelect extends ActionStdTemplateV2<EmpwoutInfo> {

	public StdEmpwoutMergeToSelect(DeciTreeOption<EmpwoutInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmpwoutInfo> buildVisitorHook(DeciTreeOption<EmpwoutInfo> option) {
		return new VisiEmpwoutMergeToSelect(option);
	}
}
