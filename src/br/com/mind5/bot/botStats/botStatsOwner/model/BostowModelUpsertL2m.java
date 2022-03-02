package br.com.mind5.bot.botStats.botStatsOwner.model;

import br.com.mind5.bot.botStats.botStatsOwner.info.BostowInfo;
import br.com.mind5.bot.botStats.botStatsOwner.model.decisionTree.BostowRootUpsertL2m;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BostowModelUpsertL2m extends ModelTemplate<BostowInfo> {

	public BostowModelUpsertL2m(BostowInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<BostowInfo> getDecisionTreeHook(DeciTreeOption<BostowInfo> option) {
		return new BostowRootUpsertL2m(option);
	}
}
