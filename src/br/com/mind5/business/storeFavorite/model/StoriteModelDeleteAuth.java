package br.com.mind5.business.storeFavorite.model;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.decisionTree.RootStoriteDeleteAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoriteModelDeleteAuth extends ModelTemplate<StoriteInfo> {

	public StoriteModelDeleteAuth(StoriteInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StoriteInfo> getDecisionTreeHook(DeciTreeOption<StoriteInfo> option) {
		return new RootStoriteDeleteAuth(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
