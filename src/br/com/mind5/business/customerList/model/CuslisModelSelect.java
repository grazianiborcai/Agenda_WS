package br.com.mind5.business.customerList.model;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.decisionTree.RootCuslisSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CuslisModelSelect extends ModelTemplate<CuslisInfo> {

	public CuslisModelSelect(CuslisInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CuslisInfo> getDecisionTreeHook(DeciTreeOption<CuslisInfo> option) {
		return new RootCuslisSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
