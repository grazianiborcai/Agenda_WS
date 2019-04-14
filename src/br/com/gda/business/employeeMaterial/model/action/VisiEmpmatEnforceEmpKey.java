package br.com.gda.business.employeeMaterial.model.action;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.info.EmpmatSetterEmpKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmpmatEnforceEmpKey extends ActionVisitorTemplateEnforce<EmpmatInfo> {
	
	@Override protected EmpmatInfo enforceHook(EmpmatInfo recordInfo) {
		InfoSetter<EmpmatInfo> attrSetter = new EmpmatSetterEmpKey();
		return attrSetter.setAttr(recordInfo);
	}
}
