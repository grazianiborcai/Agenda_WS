package br.com.mind5.business.employeeMaterial.model.action;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpmatDaoSelect extends ActionStdTemplateV2<EmpmatInfo> {

	public StdEmpmatDaoSelect(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmpmatInfo> buildVisitorHook(DeciTreeOption<EmpmatInfo> option) {
		return new VisiEmpmatDaoSelect(option);
	}
}