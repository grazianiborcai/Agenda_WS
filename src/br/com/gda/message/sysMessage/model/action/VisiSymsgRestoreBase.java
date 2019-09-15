package br.com.gda.message.sysMessage.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.message.sysMessage.info.SymsgInfo;
import br.com.gda.message.sysMessage.info.SymsgSetterRestoreBase;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiSymsgRestoreBase extends ActionVisitorTemplateEnforce<SymsgInfo> {
	
	@Override protected SymsgInfo enforceHook(SymsgInfo recordInfo) {
		InfoSetter<SymsgInfo> attrSetter = new SymsgSetterRestoreBase();
		return attrSetter.setAttr(recordInfo);
	}
}
