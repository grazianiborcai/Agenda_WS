package br.com.gda.business.employeeWorkTime.model.action;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.info.EmpwotmSetterEmpKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmpwotmEnforceEmpKey extends ActionVisitorTemplateEnforce<EmpwotmInfo> {
	
	@Override protected EmpwotmInfo enforceHook(EmpwotmInfo recordInfo) {
		InfoSetter<EmpwotmInfo> attrSetter = new EmpwotmSetterEmpKey();
		return attrSetter.setAttr(recordInfo);
	}
}
