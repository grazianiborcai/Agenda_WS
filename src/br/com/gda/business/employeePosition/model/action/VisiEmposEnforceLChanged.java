package br.com.gda.business.employeePosition.model.action;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeePosition.info.EmposSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmposEnforceLChanged extends ActionVisitorTemplateEnforce<EmposInfo> {
	
	@Override protected EmposInfo enforceHook(EmposInfo recordInfo) {
		InfoSetter<EmposInfo> attrSetter = new EmposSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
