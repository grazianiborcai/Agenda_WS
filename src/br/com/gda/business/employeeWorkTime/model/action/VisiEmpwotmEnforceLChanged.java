package br.com.gda.business.employeeWorkTime.model.action;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.info.EmpwotmSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmpwotmEnforceLChanged extends ActionVisitorTemplateEnforce<EmpwotmInfo> {
	
	@Override protected EmpwotmInfo enforceHook(EmpwotmInfo recordInfo) {
		InfoSetter<EmpwotmInfo> attrSetter = new EmpwotmSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
