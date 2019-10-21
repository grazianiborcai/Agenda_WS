package br.com.mind5.message.sysMessage.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.info.SymsgSetterRestoreBase;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiSymsgRestoreBase extends ActionVisitorTemplateEnforce<SymsgInfo> {
	
	@Override protected SymsgInfo enforceHook(SymsgInfo recordInfo) {
		InfoSetter<SymsgInfo> attrSetter = new SymsgSetterRestoreBase();
		return attrSetter.setAttr(recordInfo);
	}
}
