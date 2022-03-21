package br.com.mind5.business.employee.model.action;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpSetterPhoneCod;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiEnforcePhoneCod extends ActionVisitorTemplateEnforce<EmpInfo> {
	
	public EmpVisiEnforcePhoneCod(DeciTreeOption<EmpInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected EmpInfo enforceHook(EmpInfo recordInfo) {
		InfoSetter<EmpInfo> attrSetter = new EmpSetterPhoneCod();
		return attrSetter.setAttr(recordInfo);
	}
}
