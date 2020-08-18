package br.com.mind5.business.employeeMaterial.model.action;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpmatEnforceLChanged extends ActionVisitorTemplateEnforceV2<EmpmatInfo> {
	
	public VisiEmpmatEnforceLChanged(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmpmatInfo enforceHook(EmpmatInfo recordInfo) {
		InfoSetter<EmpmatInfo> attrSetter = new EmpmatSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
