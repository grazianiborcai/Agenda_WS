package br.com.mind5.bot.botStats.botStatsStore.model.action;

import br.com.mind5.bot.botStats.botStatsStore.info.BostodInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdBostodMergeCalonthL2m extends ActionStdTemplate<BostodInfo> {

	public StdBostodMergeCalonthL2m(DeciTreeOption<BostodInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<BostodInfo> buildVisitorHook(DeciTreeOption<BostodInfo> option) {
		return new VisiBostodMergeCalonthL2m(option);
	}
}
