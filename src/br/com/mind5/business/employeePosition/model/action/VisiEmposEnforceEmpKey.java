package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposSetterEmpKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiEmposEnforceEmpKey extends ActionVisitorTemplateEnforce<EmposInfo> {
	
	@Override protected EmposInfo enforceHook(EmposInfo recordInfo) {
		InfoSetter<EmposInfo> attrSetter = new EmposSetterEmpKey();
		return attrSetter.setAttr(recordInfo);
	}
}
