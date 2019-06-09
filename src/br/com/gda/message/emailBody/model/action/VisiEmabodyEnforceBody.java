package br.com.gda.message.emailBody.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.message.emailBody.info.EmabodyInfo;
import br.com.gda.message.emailBody.info.EmabodySetterBody;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiEmabodyEnforceBody extends ActionVisitorTemplateEnforce<EmabodyInfo> {
	
	@Override protected EmabodyInfo enforceHook(EmabodyInfo recordInfo) {
		InfoSetter<EmabodyInfo> attrSetter = new EmabodySetterBody();
		return attrSetter.setAttr(recordInfo);
	}
}
