package br.com.mind5.business.employeeWorkTime.model.action;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmSetterDel;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwotmEnforceDel extends ActionVisitorTemplateEnforceV2<EmpwotmInfo> {
	
	public VisiEmpwotmEnforceDel(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmpwotmInfo enforceHook(EmpwotmInfo recordInfo) {
		InfoSetter<EmpwotmInfo> attrSetter = new EmpwotmSetterDel();
		return attrSetter.setAttr(recordInfo);
	}
}
