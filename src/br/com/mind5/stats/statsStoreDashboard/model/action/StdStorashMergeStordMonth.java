package br.com.mind5.stats.statsStoreDashboard.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;

public final class StdStorashMergeStordMonth extends ActionStdTemplate<StorashInfo> {

	public StdStorashMergeStordMonth(DeciTreeOption<StorashInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StorashInfo> buildVisitorHook(DeciTreeOption<StorashInfo> option) {
		return new VisiStorashMergeStordMonth(option);
	}
}
