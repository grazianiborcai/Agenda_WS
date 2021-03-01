package br.com.mind5.stats.statsUserStore.userStoreAggr.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggInfo;

public final class StdStusoraggDaoSelect extends ActionStdTemplate<StusoraggInfo> {

	public StdStusoraggDaoSelect(DeciTreeOption<StusoraggInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusoraggInfo> buildVisitorHook(DeciTreeOption<StusoraggInfo> option) {
		return new VisiStusoraggDaoSelect(option);
	}
}
