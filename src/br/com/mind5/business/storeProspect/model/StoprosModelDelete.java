package br.com.mind5.business.storeProspect.model;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.decisionTree.RootStoprosDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoprosModelDelete extends ModelTemplate<StoprosInfo> {

	public StoprosModelDelete(StoprosInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StoprosInfo> getDecisionTreeHook(DeciTreeOption<StoprosInfo> option) {
		return new RootStoprosDelete(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
