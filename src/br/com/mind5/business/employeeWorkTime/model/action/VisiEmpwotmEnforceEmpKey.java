package br.com.mind5.business.employeeWorkTime.model.action;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmSetterEmpKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiEmpwotmEnforceEmpKey extends ActionVisitorTemplateEnforce<EmpwotmInfo> {
	
	@Override protected EmpwotmInfo enforceHook(EmpwotmInfo recordInfo) {
		InfoSetter<EmpwotmInfo> attrSetter = new EmpwotmSetterEmpKey();
		return attrSetter.setAttr(recordInfo);
	}
}
