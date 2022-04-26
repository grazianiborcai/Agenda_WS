package br.com.mind5.business.employeeWorkTimeSearch.model.action;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchSetterEmposKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotarchVisiEnforceEmposKey extends ActionVisitorTemplateEnforce<EmpwotarchInfo> {
	
	public EmpwotarchVisiEnforceEmposKey(DeciTreeOption<EmpwotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmpwotarchInfo enforceHook(EmpwotarchInfo recordInfo) {
		InfoSetter<EmpwotarchInfo> attrSetter = new EmpwotarchSetterEmposKey();
		return attrSetter.setAttr(recordInfo);
	}
}
