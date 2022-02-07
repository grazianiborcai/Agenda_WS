package br.com.mind5.stats.statsOwnerStore.ownerStore.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStore.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStore.model.decisionTree.RootSowotSelectLtm;

public final class SowotModelSelectLtm extends ModelTemplate<SowotInfo> {

	public SowotModelSelectLtm(SowotInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SowotInfo> getDecisionTreeHook(DeciTreeOption<SowotInfo> option) {
		return new RootSowotSelectLtm(option);
	}
}
