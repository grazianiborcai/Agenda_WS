package br.com.mind5.business.storeWorkTime.model;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.decisionTree.StowotmRootDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmModelDelete extends ModelTemplate<StowotmInfo> {

	public StowotmModelDelete(StowotmInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StowotmInfo> getDecisionTreeHook(DeciTreeOption<StowotmInfo> option) {
		return new StowotmRootDelete(option);
	}
}
