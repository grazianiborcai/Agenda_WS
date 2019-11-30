package br.com.mind5.business.employeeMaterial.model.action;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatSetterEmpKey_;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiEmpmatEnforceEmpKey_ extends ActionVisitorTemplateEnforce<EmpmatInfo> {
	
	@Override protected EmpmatInfo enforceHook(EmpmatInfo recordInfo) {
		InfoSetter<EmpmatInfo> attrSetter = new EmpmatSetterEmpKey_();
		return attrSetter.setAttr(recordInfo);
	}
}
