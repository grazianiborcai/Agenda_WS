package br.com.gda.business.employeeLeaveDate.model.action;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.info.EmplevateSetterEmposKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmplevateEnforceEmposKey extends ActionVisitorTemplateEnforce<EmplevateInfo> {
	
	@Override protected EmplevateInfo enforceHook(EmplevateInfo recordInfo) {
		InfoSetter<EmplevateInfo> attrSetter = new EmplevateSetterEmposKey();
		return attrSetter.setAttr(recordInfo);
	}
}
