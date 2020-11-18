package br.com.mind5.business.employeeSearch.model.action;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.info.EmparchSetterEmailKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmparchEnforceEmailKey extends ActionVisitorTemplateEnforce<EmparchInfo> {
	
	public VisiEmparchEnforceEmailKey(DeciTreeOption<EmparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmparchInfo enforceHook(EmparchInfo recordInfo) {
		InfoSetter<EmparchInfo> attrSetter = new EmparchSetterEmailKey();
		return attrSetter.setAttr(recordInfo);
	}
}
