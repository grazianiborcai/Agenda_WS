package br.com.mind5.business.employee.model.action;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpSetterCodUserCateg;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiEmpEnforceUserCateg extends ActionVisitorTemplateEnforce<EmpInfo> {
	
	@Override protected EmpInfo enforceHook(EmpInfo recordInfo) {
		InfoSetter<EmpInfo> attrSetter = new EmpSetterCodUserCateg();
		return attrSetter.setAttr(recordInfo);
	}
}
