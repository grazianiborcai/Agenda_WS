package br.com.mind5.masterData.state;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.decisionTree.RootStateSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
