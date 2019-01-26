package br.com.gda.business.employee.model.action;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.info.EmpSetterAddressKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmpEnforceAddressKey extends ActionVisitorTemplateEnforce<EmpInfo> {
	
	@Override protected EmpInfo enforceHook(EmpInfo recordInfo) {
		InfoSetter<EmpInfo> attrSetter = new EmpSetterAddressKey();
		return attrSetter.setAttr(recordInfo);
	}
}
