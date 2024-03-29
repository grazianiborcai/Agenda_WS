package br.com.mind5.payment.storePartnerList.model;

import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.model.decisionTree.StoplisRootSearch;

public final class StoplisModelSearch extends ModelTemplate<StoplisInfo> {

	public StoplisModelSearch(StoplisInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StoplisInfo> getDecisionTreeHook(DeciTreeOption<StoplisInfo> option) {
		return new StoplisRootSearch(option);
	}
}
