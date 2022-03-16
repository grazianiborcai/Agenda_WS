package br.com.mind5.payment.storePartnerSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSearch.model.decisionTree.StoparchRootSelectStore;

public final class StoparchCheckExistStore extends ModelCheckerTemplateAction<StoparchInfo, StoparchInfo> {
	
	public StoparchCheckExistStore(ModelCheckerOption option) {
		super(option, StoparchInfo.class);
	}
	

	
	@Override protected ActionStd<StoparchInfo> buildActionHook(DeciTreeOption<StoparchInfo> option) {
		ActionStd<StoparchInfo> select = new StoparchRootSelectStore(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAYPAR_STORE_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAYPAR_STORE_SEARCH_NOT_FOUND;
	}
}
