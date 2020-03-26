package br.com.mind5.payment.creditCard.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.StdCrecardSelect;

public final class CrecardCheckExist extends ModelCheckerTemplateAction<CrecardInfo, CrecardInfo> {	
	
	public CrecardCheckExist(ModelCheckerOption option) {
		super(option, CrecardInfo.class);
	}
	
	
	
	@Override protected ActionStd<CrecardInfo> buildActionHook(DeciTreeOption<CrecardInfo> option) {
		ActionStd<CrecardInfo> select = new StdCrecardSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CREDIT_CARD_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_NOT_FOUND;
	}
}
