package br.com.gda.message.sysMessage.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.message.sysMessage.info.SymsgInfo;
import br.com.gda.message.sysMessage.info.SymsgSetterEnglish;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiSymsgEnforceEnglish extends ActionVisitorTemplateEnforce<SymsgInfo> {
	
	@Override protected SymsgInfo enforceHook(SymsgInfo recordInfo) {
		InfoSetter<SymsgInfo> attrSetter = new SymsgSetterEnglish();
		return attrSetter.setAttr(recordInfo);
	}
}
