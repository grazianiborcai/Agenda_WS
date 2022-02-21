package br.com.mind5.bot.botStats.botStatsStoreSchedule.model;

import br.com.mind5.bot.botStats.botStatsStoreSchedule.info.BostodInfo;
import br.com.mind5.bot.botStats.botStatsStoreSchedule.model.decisionTree.RootBostodUpsertL2m;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BostodModelUpsertL2m extends ModelTemplate<BostodInfo> {

	public BostodModelUpsertL2m(BostodInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<BostodInfo> getDecisionTreeHook(DeciTreeOption<BostodInfo> option) {
		return new RootBostodUpsertL2m(option);
	}
}
