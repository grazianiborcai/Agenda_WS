package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiEmposEnforceCreatedOn extends ActionVisitorTemplateEnforce<EmposInfo> {
	
	@Override protected EmposInfo enforceHook(EmposInfo recordInfo) {
		InfoSetter<EmposInfo> attrSetter = new EmposSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
