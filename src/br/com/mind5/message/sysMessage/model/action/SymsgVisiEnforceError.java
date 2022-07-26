package br.com.mind5.message.sysMessage.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.info.SymsgSetterError;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SymsgVisiEnforceError extends ActionVisitorTemplateEnforce<SymsgInfo> {
	
	public SymsgVisiEnforceError(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected SymsgInfo enforceHook(SymsgInfo recordInfo) {
		InfoSetter<SymsgInfo> attrSetter = new SymsgSetterError();
		return attrSetter.setAttr(recordInfo);
	}
}
