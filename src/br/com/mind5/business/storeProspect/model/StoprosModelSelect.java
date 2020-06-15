package br.com.mind5.business.storeProspect.model;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.decisionTree.RootStoprosSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprosModelSelect extends ModelTemplate<StoprosInfo> {

	public StoprosModelSelect(StoprosInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StoprosInfo> getDecisionTreeHook(DeciTreeOption<StoprosInfo> option) {
		return new RootStoprosSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
