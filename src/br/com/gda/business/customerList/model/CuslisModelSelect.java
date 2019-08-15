package br.com.gda.business.customerList.model;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.business.customerList.model.decisionTree.RootCuslisSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
