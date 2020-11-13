package br.com.mind5.config.sysStorePartitioning.model.action;

import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSytotinDaoSelect extends ActionStdTemplate<SytotinInfo> {

	public StdSytotinDaoSelect(DeciTreeOption<SytotinInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SytotinInfo> buildVisitorHook(DeciTreeOption<SytotinInfo> option) {
		return new VisiSytotinDaoSelect(option);
	}
}
