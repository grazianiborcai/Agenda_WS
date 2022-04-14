package br.com.mind5.business.storeLunchTime.model;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.decisionTree.StuntmRootDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmModelDelete extends ModelTemplate<StuntmInfo> {

	public StuntmModelDelete(StuntmInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StuntmInfo> getDecisionTreeHook(DeciTreeOption<StuntmInfo> option) {
		return new StuntmRootDelete(option);
	}
}
