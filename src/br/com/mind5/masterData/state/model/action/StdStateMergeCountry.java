package br.com.mind5.masterData.state.model.action;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStateMergeCountry extends ActionStdTemplate<StateInfo> {

	public StdStateMergeCountry(DeciTreeOption<StateInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StateInfo> buildVisitorHook(DeciTreeOption<StateInfo> option) {
		return new VisiStateMergeCountry(option);
	}
}
