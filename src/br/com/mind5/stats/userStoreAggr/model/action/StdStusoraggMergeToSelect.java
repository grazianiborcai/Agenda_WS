package br.com.mind5.stats.userStoreAggr.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStoreAggr.info.StusoraggInfo;

public final class StdStusoraggMergeToSelect extends ActionStdTemplate<StusoraggInfo> {

	public StdStusoraggMergeToSelect(DeciTreeOption<StusoraggInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusoraggInfo> buildVisitorHook(DeciTreeOption<StusoraggInfo> option) {
		return new VisiStusoraggMergeToSelect(option);
	}
}
