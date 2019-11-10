package br.com.mind5.business.storeWorkTime.model.checker;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.model.decisionTree.RootEmposarchSelect;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotmCheckEmposarch extends ModelCheckerTemplateActionV2<StowotmInfo, EmposarchInfo> {
	
	public StowotmCheckEmposarch(ModelCheckerOption option) {
		super(option, EmposarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmposarchInfo> buildActionHook(DeciTreeOption<EmposarchInfo> option) {
		ActionStd<EmposarchInfo> select = new RootEmposarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_WTIME_HAS_EMPOS;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_EMPOS_NOT_FOUND;
	}
}
