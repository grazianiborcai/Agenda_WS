package br.com.gda.business.employee.model.action;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.info.EmpSetterCodAuthGroup;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmpEnforceAuthGroup extends ActionVisitorTemplateEnforce<EmpInfo> {
	
	@Override protected EmpInfo enforceHook(EmpInfo recordInfo) {
		InfoSetter<EmpInfo> attrSetter = new EmpSetterCodAuthGroup();
		return attrSetter.setAttr(recordInfo);
	}
}
