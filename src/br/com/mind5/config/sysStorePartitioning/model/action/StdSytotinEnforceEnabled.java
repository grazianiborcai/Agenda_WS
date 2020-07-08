package br.com.mind5.config.sysStorePartitioning.model.action;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSytotinEnforceEnabled extends ActionStdTemplateV2<SytotinInfo> {

	public StdSytotinEnforceEnabled(DeciTreeOption<SytotinInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SytotinInfo> buildVisitorHook(DeciTreeOption<SytotinInfo> option) {
		return new VisiSytotinEnforceEnabled(option);
	}
}
