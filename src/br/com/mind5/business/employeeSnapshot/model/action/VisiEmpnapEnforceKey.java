package br.com.mind5.business.employeeSnapshot.model.action;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapSetterKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;

final class VisiEmpnapEnforceKey extends ActionVisitorTemplateEnforceV1<EmpnapInfo> {

	@Override protected EmpnapInfo enforceHook(EmpnapInfo recordInfo) {
		InfoSetter<EmpnapInfo> attrSetter = new EmpnapSetterKey();
		return attrSetter.setAttr(recordInfo);
	}
}
