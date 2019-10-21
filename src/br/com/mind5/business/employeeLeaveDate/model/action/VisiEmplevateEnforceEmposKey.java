package br.com.mind5.business.employeeLeaveDate.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplevateSetterEmposKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiEmplevateEnforceEmposKey extends ActionVisitorTemplateEnforce<EmplevateInfo> {
	
	@Override protected EmplevateInfo enforceHook(EmplevateInfo recordInfo) {
		InfoSetter<EmplevateInfo> attrSetter = new EmplevateSetterEmposKey();
		return attrSetter.setAttr(recordInfo);
	}
}
