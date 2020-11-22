package br.com.mind5.business.employeeSearch.model.action;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.info.EmparchSetterSytotauhKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmparchEnforceSytotauhKey extends ActionVisitorTemplateEnforce<EmparchInfo> {
	
	public VisiEmparchEnforceSytotauhKey(DeciTreeOption<EmparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmparchInfo enforceHook(EmparchInfo recordInfo) {
		InfoSetter<EmparchInfo> attrSetter = new EmparchSetterSytotauhKey();
		return attrSetter.setAttr(recordInfo);
	}
}
