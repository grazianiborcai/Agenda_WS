package br.com.gda.business.employeeLeaveDate.model.action;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.info.EmplevateSetterDel;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmplevateEnforceDel extends ActionVisitorTemplateEnforce<EmplevateInfo> {
	
	@Override protected EmplevateInfo enforceHook(EmplevateInfo recordInfo) {
		InfoSetter<EmplevateInfo> attrSetter = new EmplevateSetterDel();
		return attrSetter.setAttr(recordInfo);
	}
}
