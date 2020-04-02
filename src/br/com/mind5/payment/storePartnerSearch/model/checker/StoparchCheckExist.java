package br.com.mind5.payment.storePartnerSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSearch.model.decisionTree.RootStoparchSelect;

public final class StoparchCheckExist extends ModelCheckerTemplateAction<StoparchInfo, StoparchInfo> {
	
	public StoparchCheckExist(ModelCheckerOption option) {
		super(option, StoparchInfo.class);
	}
	

	
	@Override protected ActionStdV1<StoparchInfo> buildActionHook(DeciTreeOption<StoparchInfo> option) {
		ActionStdV1<StoparchInfo> select = new RootStoparchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAYPAR_STORE_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAYPAR_STORE_SEARCH_NOT_FOUND;
	}
}
