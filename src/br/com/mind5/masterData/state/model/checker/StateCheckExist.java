package br.com.mind5.masterData.state.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.action.StdStateDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StateCheckExist extends ModelCheckerTemplateActionV2<StateInfo, StateInfo> {
	
	public StateCheckExist(ModelCheckerOption option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<StateInfo> buildActionHook(DeciTreeOption<StateInfo> option) {
		ActionStdV2<StateInfo> select = new StdStateDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STATE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STATE_NOT_FOUND;
	}
}
