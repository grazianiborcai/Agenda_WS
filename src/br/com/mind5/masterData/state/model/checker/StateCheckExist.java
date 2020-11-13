package br.com.mind5.masterData.state.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.action.StdStateDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StateCheckExist extends ModelCheckerTemplateAction<StateInfo, StateInfo> {
	
	public StateCheckExist(ModelCheckerOption option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected ActionStd<StateInfo> buildActionHook(DeciTreeOption<StateInfo> option) {
		ActionStd<StateInfo> select = new StdStateDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STATE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STATE_NOT_FOUND;
	}
}
