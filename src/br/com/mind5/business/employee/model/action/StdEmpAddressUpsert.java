package br.com.mind5.business.employee.model.action;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpAddressUpsert extends ActionStdTemplateV2<EmpInfo> {

	public StdEmpAddressUpsert(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmpInfo> buildVisitorHook(DeciTreeOption<EmpInfo> option) {
		return new VisiEmpAddressUpsert(option);
	}
}
