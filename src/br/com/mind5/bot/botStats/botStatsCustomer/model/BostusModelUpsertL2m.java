package br.com.mind5.bot.botStats.botStatsCustomer.model;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.bot.botStats.botStatsCustomer.model.decisionTree.BostusRootUpsertL2m;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BostusModelUpsertL2m extends ModelTemplate<BostusInfo> {

	public BostusModelUpsertL2m(BostusInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<BostusInfo> getDecisionTreeHook(DeciTreeOption<BostusInfo> option) {
		return new BostusRootUpsertL2m(option);
	}
}
