package br.com.mind5.bot.botStats.botStatsCustomer.model;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.bot.botStats.botStatsCustomer.model.decisionTree.BostodRootUpsertL2m;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BostodModelUpsertL2m extends ModelTemplate<BostusInfo> {

	public BostodModelUpsertL2m(BostusInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<BostusInfo> getDecisionTreeHook(DeciTreeOption<BostusInfo> option) {
		return new BostodRootUpsertL2m(option);
	}
}
