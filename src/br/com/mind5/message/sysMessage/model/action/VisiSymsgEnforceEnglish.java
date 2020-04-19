package br.com.mind5.message.sysMessage.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.info.SymsgSetterEnglish;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSymsgEnforceEnglish extends ActionVisitorTemplateEnforceV2<SymsgInfo> {
	
	public VisiSymsgEnforceEnglish(DeciTreeOption<SymsgInfo> option) {
		super(option);
	}
	
	
	
	@Override protected SymsgInfo enforceHook(SymsgInfo recordInfo) {
		InfoSetter<SymsgInfo> attrSetter = new SymsgSetterEnglish();
		return attrSetter.setAttr(recordInfo);
	}
}
