package br.com.mind5.masterData.state.model.action;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStateDaoSelect extends ActionStdTemplateV2<StateInfo> {

	public StdStateDaoSelect(DeciTreeOption<StateInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StateInfo> buildVisitorHook(DeciTreeOption<StateInfo> option) {
		return new VisiStateDaoSelect(option);
	}
}
