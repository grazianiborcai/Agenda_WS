package br.com.mind5.stats.statsOwnerDashboard.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.model.decisionTree.RootSowashSelectLtm;

public final class SowashModelSelectLtm extends ModelTemplate<SowashInfo> {

	public SowashModelSelectLtm(SowashInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SowashInfo> getDecisionTreeHook(DeciTreeOption<SowashInfo> option) {
		return new RootSowashSelectLtm(option);
	}
}
