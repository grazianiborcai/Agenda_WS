package br.com.mind5.business.employeeMaterial.model.action;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatSetterEmpKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpmatEnforceEmpKey extends ActionVisitorTemplateEnforce<EmpmatInfo> {
	
	public VisiEmpmatEnforceEmpKey(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmpmatInfo enforceHook(EmpmatInfo recordInfo) {
		InfoSetter<EmpmatInfo> attrSetter = new EmpmatSetterEmpKey();
		return attrSetter.setAttr(recordInfo);
	}
}
