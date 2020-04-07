package br.com.mind5.business.storeLeaveDateSearch.model.checker;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.business.storeLeaveDateSearch.model.decisionTree.RootStolarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolarchCheckExist extends ModelCheckerTemplateActionV2<StolarchInfo, StolarchInfo> {
	
	public StolarchCheckExist(ModelCheckerOption option) {
		super(option, StolarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<StolarchInfo> buildActionHook(DeciTreeOption<StolarchInfo> option) {
		ActionStdV1<StolarchInfo> select = new RootStolarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.STORE_LDATE_SEARCH_ALREADY_EXIST;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.STORE_LDATE_SEARCH_NOT_FOUND;
	}
}
