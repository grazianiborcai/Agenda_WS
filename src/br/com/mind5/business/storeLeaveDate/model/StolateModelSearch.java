package br.com.mind5.business.storeLeaveDate.model;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.decisionTree.RootStolateSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolateModelSearch extends ModelTemplate<StolateInfo> {

	public StolateModelSearch(StolateInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StolateInfo> getDecisionTreeHook(DeciTreeOption<StolateInfo> option) {
		return new RootStolateSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
