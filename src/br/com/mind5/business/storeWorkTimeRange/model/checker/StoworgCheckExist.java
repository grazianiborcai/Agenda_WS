package br.com.mind5.business.storeWorkTimeRange.model.checker;

import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.business.storeWorkTimeRange.model.decisionTree.RootStoworgSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoworgCheckExist extends ModelCheckerTemplateActionV2<StoworgInfo, StoworgInfo> {
	
	public StoworgCheckExist(ModelCheckerOption option) {
		super(option, StoworgInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<StoworgInfo> buildActionHook(DeciTreeOption<StoworgInfo> option) {
		ActionStdV1<StoworgInfo> select = new RootStoworgSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_WTIME_RANGE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_RANGE_NOT_FOUND;
	}
}
