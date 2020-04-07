package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.business.masterData.model.action.StdStateSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StateCheckExist extends ModelCheckerTemplateActionV2<StateInfo, StateInfo> {
	
	public StateCheckExist(ModelCheckerOption option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<StateInfo> buildActionHook(DeciTreeOption<StateInfo> option) {
		ActionStdV1<StateInfo> select = new StdStateSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STATE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STATE_NOT_FOUND;
	}
}
