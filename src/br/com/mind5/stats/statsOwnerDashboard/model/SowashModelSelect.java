package br.com.mind5.stats.statsOwnerDashboard.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.model.decisionTree.RootSowashSelect;

public final class SowashModelSelect extends ModelTemplate<SowashInfo> {

	public SowashModelSelect(SowashInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<SowashInfo> getDecisionTreeHook(DeciTreeOption<SowashInfo> option) {
		return new RootSowashSelect(option);
	}
}
