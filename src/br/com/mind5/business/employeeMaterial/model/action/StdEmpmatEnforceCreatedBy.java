package br.com.mind5.business.employeeMaterial.model.action;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpmatEnforceCreatedBy extends ActionStdTemplate<EmpmatInfo> {

	public StdEmpmatEnforceCreatedBy(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmpmatInfo> buildVisitorHook(DeciTreeOption<EmpmatInfo> option) {
		return new VisiEmpmatEnforceCreatedBy(option);
	}
}
