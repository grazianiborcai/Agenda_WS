package br.com.mind5.business.employeeLeaveDate.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateSetterValidTo;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiEmplateEnforceValidTo extends ActionVisitorTemplateEnforce<EmplateInfo> {
	
	@Override protected EmplateInfo enforceHook(EmplateInfo recordInfo) {
		InfoSetter<EmplateInfo> attrSetter = new EmplateSetterValidTo();
		return attrSetter.setAttr(recordInfo);
	}
}
