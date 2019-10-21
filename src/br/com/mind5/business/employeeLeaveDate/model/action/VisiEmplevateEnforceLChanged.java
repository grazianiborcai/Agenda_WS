package br.com.mind5.business.employeeLeaveDate.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplevateSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiEmplevateEnforceLChanged extends ActionVisitorTemplateEnforce<EmplevateInfo> {
	
	@Override protected EmplevateInfo enforceHook(EmplevateInfo recordInfo) {
		InfoSetter<EmplevateInfo> attrSetter = new EmplevateSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
