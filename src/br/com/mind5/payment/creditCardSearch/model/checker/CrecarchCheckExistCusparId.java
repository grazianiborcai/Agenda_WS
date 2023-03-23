package br.com.mind5.payment.creditCardSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;
import br.com.mind5.payment.creditCardSearch.model.decisionTree.CrecarchRootSelectCusparId;

public final class CrecarchCheckExistCusparId extends ModelCheckerTemplateAction<CrecarchInfo, CrecarchInfo> {
	
	public CrecarchCheckExistCusparId(ModelCheckerOption option) {
		super(option, CrecarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<CrecarchInfo> buildActionHook(DeciTreeOption<CrecarchInfo> option) {
		ActionStd<CrecarchInfo> select = new CrecarchRootSelectCusparId(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CREDIT_CARD_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_SEARCH_NOT_FOUND;
	}
}
