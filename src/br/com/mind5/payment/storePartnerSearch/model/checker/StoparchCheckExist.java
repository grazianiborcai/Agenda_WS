package br.com.mind5.payment.storePartnerSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSearch.model.decisionTree.RootStoparchSelect;

public final class StoparchCheckExist extends ModelCheckerTemplateActionV2<StoparchInfo, StoparchInfo> {
	
	public StoparchCheckExist(ModelCheckerOption option) {
		super(option, StoparchInfo.class);
	}
	

	
	@Override protected ActionStdV2<StoparchInfo> buildActionHook(DeciTreeOption<StoparchInfo> option) {
		ActionStdV2<StoparchInfo> select = new RootStoparchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAYPAR_STORE_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAYPAR_STORE_SEARCH_NOT_FOUND;
	}
}
