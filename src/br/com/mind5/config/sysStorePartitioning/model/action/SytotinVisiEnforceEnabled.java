package br.com.mind5.config.sysStorePartitioning.model.action;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.info.SytotinSetterEnabled;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SytotinVisiEnforceEnabled extends ActionVisitorTemplateEnforce<SytotinInfo> {
	
	public SytotinVisiEnforceEnabled(DeciTreeOption<SytotinInfo> option) {
		super(option);
	}

	
	
	@Override protected SytotinInfo enforceHook(SytotinInfo recordInfo) {
		InfoSetter<SytotinInfo> attrSetter = new SytotinSetterEnabled();
		return attrSetter.setAttr(recordInfo);
	}
}
