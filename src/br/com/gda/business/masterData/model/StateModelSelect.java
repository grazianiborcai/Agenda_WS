package br.com.gda.business.masterData.model;

import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.business.masterData.model.decisionTree.RootStateSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StateModelSelect extends ModelTemplate<StateInfo> {

	public StateModelSelect(StateInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<StateInfo> getDecisionTreeHook(DeciTreeOption<StateInfo> option) {
		return new RootStateSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
