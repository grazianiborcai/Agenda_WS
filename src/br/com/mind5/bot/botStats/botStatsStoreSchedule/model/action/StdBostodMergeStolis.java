package br.com.mind5.bot.botStats.botStatsStoreSchedule.model.action;

import br.com.mind5.bot.botStats.botStatsStoreSchedule.info.BostodInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdBostodMergeStolis extends ActionStdTemplate<BostodInfo> {

	public StdBostodMergeStolis(DeciTreeOption<BostodInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<BostodInfo> buildVisitorHook(DeciTreeOption<BostodInfo> option) {
		return new VisiBostodMergeStolis(option);
	}
}
