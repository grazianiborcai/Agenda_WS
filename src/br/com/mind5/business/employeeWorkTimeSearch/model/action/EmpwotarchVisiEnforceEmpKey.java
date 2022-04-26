package br.com.mind5.business.employeeWorkTimeSearch.model.action;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchSetterEmpKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotarchVisiEnforceEmpKey extends ActionVisitorTemplateEnforce<EmpwotarchInfo> {
	
	public EmpwotarchVisiEnforceEmpKey(DeciTreeOption<EmpwotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmpwotarchInfo enforceHook(EmpwotarchInfo recordInfo) {
		InfoSetter<EmpwotarchInfo> attrSetter = new EmpwotarchSetterEmpKey();
		return attrSetter.setAttr(recordInfo);
	}
}
