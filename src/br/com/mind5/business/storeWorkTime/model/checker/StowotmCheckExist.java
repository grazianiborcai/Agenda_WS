package br.com.mind5.business.storeWorkTime.model.checker;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.action.StdStowotmDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmCheckExist extends ModelCheckerTemplateActionV2<StowotmInfo, StowotmInfo> {
	
	public StowotmCheckExist(ModelCheckerOption option) {
		super(option, StowotmInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<StowotmInfo> buildActionHook(DeciTreeOption<StowotmInfo> option) {
		ActionStdV1<StowotmInfo> select = new StdStowotmDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_WTIME_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_NOT_FOUND;
	}
}
