package br.com.mind5.business.employee.model.action;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpSetterAddressCod;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpEnforceAddressCod extends ActionVisitorTemplateEnforceV2<EmpInfo> {
	
	public VisiEmpEnforceAddressCod(DeciTreeOption<EmpInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected EmpInfo enforceHook(EmpInfo recordInfo) {
		InfoSetter<EmpInfo> attrSetter = new EmpSetterAddressCod();
		return attrSetter.setAttr(recordInfo);
	}
}
