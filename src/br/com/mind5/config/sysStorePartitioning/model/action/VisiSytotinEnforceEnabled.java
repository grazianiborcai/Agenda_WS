package br.com.mind5.config.sysStorePartitioning.model.action;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.info.SytotinSetterEnabled;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSytotinEnforceEnabled extends ActionVisitorTemplateEnforceV2<SytotinInfo> {
	
	public VisiSytotinEnforceEnabled(DeciTreeOption<SytotinInfo> option) {
		super(option);
	}

	
	
	@Override protected SytotinInfo enforceHook(SytotinInfo recordInfo) {
		InfoSetter<SytotinInfo> attrSetter = new SytotinSetterEnabled();
		return attrSetter.setAttr(recordInfo);
	}
}
