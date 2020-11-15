package br.com.mind5.business.employeeWorkTime.model.action;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmSetterStoreKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpwotmEnforceStoreKey extends ActionVisitorTemplateEnforce<EmpwotmInfo> {
	
	public VisiEmpwotmEnforceStoreKey(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmpwotmInfo enforceHook(EmpwotmInfo recordInfo) {
		InfoSetter<EmpwotmInfo> attrSetter = new EmpwotmSetterStoreKey();
		return attrSetter.setAttr(recordInfo);
	}
}
