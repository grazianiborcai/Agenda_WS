package br.com.gda.business.employee.model.action;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.info.EmpSetterCodUserCateg;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmpEnforceUserCateg extends ActionVisitorTemplateEnforce<EmpInfo> {
	
	@Override protected EmpInfo enforceHook(EmpInfo recordInfo) {
		InfoSetter<EmpInfo> attrSetter = new EmpSetterCodUserCateg();
		return attrSetter.setAttr(recordInfo);
	}
}
