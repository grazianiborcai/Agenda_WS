package br.com.mind5.message.sysMessage.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.info.SymsgSetterNotfound;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiSymsgEnforceNotfound extends ActionVisitorTemplateEnforce<SymsgInfo> {
	
	@Override protected SymsgInfo enforceHook(SymsgInfo recordInfo) {
		InfoSetter<SymsgInfo> attrSetter = new SymsgSetterNotfound();
		return attrSetter.setAttr(recordInfo);
	}
}
