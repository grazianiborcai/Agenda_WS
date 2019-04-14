package br.com.gda.business.employeeMaterial.model.action;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.info.EmpmatSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmpmatEnforceLChanged extends ActionVisitorTemplateEnforce<EmpmatInfo> {
	
	@Override protected EmpmatInfo enforceHook(EmpmatInfo recordInfo) {
		InfoSetter<EmpmatInfo> attrSetter = new EmpmatSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
