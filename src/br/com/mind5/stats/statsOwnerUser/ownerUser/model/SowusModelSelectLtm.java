package br.com.mind5.stats.statsOwnerUser.ownerUser.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUser.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUser.model.decisionTree.RootSowusSelectLtm;

public final class SowusModelSelectLtm extends ModelTemplate<SowusInfo> {

	public SowusModelSelectLtm(SowusInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SowusInfo> getDecisionTreeHook(DeciTreeOption<SowusInfo> option) {
		return new RootSowusSelectLtm(option);
	}
}
