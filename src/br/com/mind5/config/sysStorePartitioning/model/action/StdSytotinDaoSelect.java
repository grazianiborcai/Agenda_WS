package br.com.mind5.config.sysStorePartitioning.model.action;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSytotinDaoSelect extends ActionStdTemplateV2<SytotinInfo> {

	public StdSytotinDaoSelect(DeciTreeOption<SytotinInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SytotinInfo> buildVisitorHook(DeciTreeOption<SytotinInfo> option) {
		return new VisiSytotinDaoSelect(option);
	}
}
