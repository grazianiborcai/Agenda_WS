package br.com.mind5.masterData.position.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.position.info.PositionInfo;
import br.com.mind5.masterData.position.model.action.StdPositionDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PositionCheckExist extends ModelCheckerTemplateAction<PositionInfo, PositionInfo> {
	
	public PositionCheckExist(ModelCheckerOption option) {
		super(option, PositionInfo.class);
	}
	
	
	
	@Override protected ActionStd<PositionInfo> buildActionHook(DeciTreeOption<PositionInfo> option) {
		ActionStd<PositionInfo> select = new StdPositionDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.POSITION_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.POSITION_NOT_FOUND;
	}
}
