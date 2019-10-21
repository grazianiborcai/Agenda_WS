package br.com.mind5.message.sysMessage.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.info.SymsgSetterError;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiSymsgEnforceError extends ActionVisitorTemplateEnforce<SymsgInfo> {
	
	@Override protected SymsgInfo enforceHook(SymsgInfo recordInfo) {
		InfoSetter<SymsgInfo> attrSetter = new SymsgSetterError();
		return attrSetter.setAttr(recordInfo);
	}
}
