package br.com.gda.business.employeeSnapshot.model.action;

import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.business.employeeSnapshot.info.EmpnapSetterKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmpnapEnforceKey extends ActionVisitorTemplateEnforce<EmpnapInfo> {

	@Override protected EmpnapInfo enforceHook(EmpnapInfo recordInfo) {
		InfoSetter<EmpnapInfo> attrSetter = new EmpnapSetterKey();
		return attrSetter.setAttr(recordInfo);
	}
}
