package br.com.mind5.business.customerList.model;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.decisionTree.RootCuslisSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CuslisModelSearch extends ModelTemplate<CuslisInfo> {

	public CuslisModelSearch(CuslisInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CuslisInfo> getDecisionTreeHook(DeciTreeOption<CuslisInfo> option) {
		return new RootCuslisSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}