package br.com.mind5.stats.statsStoreAccount.storeAccount.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccount.model.decisionTree.RootStoracSelectLtm;

public final class StoracModelSelectLtm extends ModelTemplate<StoracInfo> {

	public StoracModelSelectLtm(StoracInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StoracInfo> getDecisionTreeHook(DeciTreeOption<StoracInfo> option) {
		return new RootStoracSelectLtm(option);
	}
}
