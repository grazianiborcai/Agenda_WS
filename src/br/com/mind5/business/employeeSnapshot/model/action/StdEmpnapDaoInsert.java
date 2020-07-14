package br.com.mind5.business.employeeSnapshot.model.action;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpnapDaoInsert extends ActionStdTemplateV2<EmpnapInfo> {

	public StdEmpnapDaoInsert(DeciTreeOption<EmpnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmpnapInfo> buildVisitorHook(DeciTreeOption<EmpnapInfo> option) {
		return new VisiEmpnapDaoInsert(option);
	}
}
