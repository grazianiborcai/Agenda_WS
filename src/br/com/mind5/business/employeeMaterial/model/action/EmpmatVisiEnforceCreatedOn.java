package br.com.mind5.business.employeeMaterial.model.action;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatVisiEnforceCreatedOn extends ActionVisitorTemplateEnforce<EmpmatInfo> {
	
	public EmpmatVisiEnforceCreatedOn(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmpmatInfo enforceHook(EmpmatInfo recordInfo) {
		InfoSetter<EmpmatInfo> attrSetter = new EmpmatSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
