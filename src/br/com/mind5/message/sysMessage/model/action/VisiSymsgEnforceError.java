package br.com.mind5.message.sysMessage.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.info.SymsgSetterError;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSymsgEnforceError extends ActionVisitorTemplateEnforceV2<SymsgInfo> {
	
	public VisiSymsgEnforceError(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected SymsgInfo enforceHook(SymsgInfo recordInfo) {
		InfoSetter<SymsgInfo> attrSetter = new SymsgSetterError();
		return attrSetter.setAttr(recordInfo);
	}
}
