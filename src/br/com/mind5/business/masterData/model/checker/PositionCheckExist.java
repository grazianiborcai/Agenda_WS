package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.PositionInfo;
import br.com.mind5.business.masterData.model.action.StdPositionSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PositionCheckExist extends ModelCheckerTemplateAction<PositionInfo, PositionInfo> {
	
	public PositionCheckExist(ModelCheckerOption option) {
		super(option, PositionInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<PositionInfo> buildActionHook(DeciTreeOption<PositionInfo> option) {
		ActionStdV1<PositionInfo> select = new StdPositionSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.POSITION_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.POSITION_NOT_FOUND;
	}
}
