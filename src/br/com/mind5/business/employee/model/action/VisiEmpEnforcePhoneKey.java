package br.com.mind5.business.employee.model.action;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpSetterPhoneKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpEnforcePhoneKey extends ActionVisitorTemplateEnforce<EmpInfo> {
	
	public VisiEmpEnforcePhoneKey(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmpInfo enforceHook(EmpInfo recordInfo) {
		InfoSetter<EmpInfo> attrSetter = new EmpSetterPhoneKey();
		return attrSetter.setAttr(recordInfo);
	}
}
