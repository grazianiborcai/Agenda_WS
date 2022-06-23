package br.com.mind5.stats.statsStoreDashboard.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;
import br.com.mind5.stats.statsStoreDashboard.model.decisionTree.StorashRootSelectAuth;

public final class StorashModelSelectAuth extends ModelTemplate<StorashInfo> {

	public StorashModelSelectAuth(StorashInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StorashInfo> getDecisionTreeHook(DeciTreeOption<StorashInfo> option) {
		return new StorashRootSelectAuth(option);
	}
}
