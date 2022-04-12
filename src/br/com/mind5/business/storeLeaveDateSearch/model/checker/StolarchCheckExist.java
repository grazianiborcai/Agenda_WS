package br.com.mind5.business.storeLeaveDateSearch.model.checker;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.business.storeLeaveDateSearch.model.decisionTree.StolarchRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolarchCheckExist extends ModelCheckerTemplateAction<StolarchInfo, StolarchInfo> {
	
	public StolarchCheckExist(ModelCheckerOption option) {
		super(option, StolarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<StolarchInfo> buildActionHook(DeciTreeOption<StolarchInfo> option) {
		ActionStd<StolarchInfo> select = new StolarchRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_LDATE_SEARCH_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_LDATE_SEARCH_NOT_FOUND;
	}
}
