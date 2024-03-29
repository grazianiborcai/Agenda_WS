package br.com.mind5.business.storeWorkTimeSearch.model.checker;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.decisionTree.StowotarchRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotarchCheckExist extends ModelCheckerTemplateAction<StowotarchInfo, StowotarchInfo> {
	
	public StowotarchCheckExist(ModelCheckerOption option) {
		super(option, StowotarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<StowotarchInfo> buildActionHook(DeciTreeOption<StowotarchInfo> option) {
		ActionStd<StowotarchInfo> select = new StowotarchRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_WTIME_SEARCH_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_WTIME_SEARCH_NOT_FOUND;
	}
}
