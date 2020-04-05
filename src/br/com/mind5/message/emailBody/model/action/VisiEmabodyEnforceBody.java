package br.com.mind5.message.emailBody.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.message.emailBody.info.EmabodySetterBody;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV1;

final class VisiEmabodyEnforceBody extends ActionVisitorTemplateEnforceV1<EmabodyInfo> {
	
	@Override protected EmabodyInfo enforceHook(EmabodyInfo recordInfo) {
		InfoSetter<EmabodyInfo> attrSetter = new EmabodySetterBody();
		return attrSetter.setAttr(recordInfo);
	}
}
