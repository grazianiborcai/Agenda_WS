package br.com.mind5.business.employeeLeaveDate.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiEmplateEnforceCreatedOn extends ActionVisitorTemplateEnforce<EmplateInfo> {
	
	@Override protected EmplateInfo enforceHook(EmplateInfo recordInfo) {
		InfoSetter<EmplateInfo> attrSetter = new EmplateSetterCreatedOn();
		return attrSetter.setAttr(recordInfo);
	}
}
