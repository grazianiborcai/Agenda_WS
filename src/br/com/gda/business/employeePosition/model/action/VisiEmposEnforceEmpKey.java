package br.com.gda.business.employeePosition.model.action;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeePosition.info.EmposSetterEmpKey;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmposEnforceEmpKey extends ActionVisitorTemplateEnforce<EmposInfo> {
	
	@Override protected EmposInfo enforceHook(EmposInfo recordInfo) {
		InfoSetter<EmposInfo> attrSetter = new EmposSetterEmpKey();
		return attrSetter.setAttr(recordInfo);
	}
}
