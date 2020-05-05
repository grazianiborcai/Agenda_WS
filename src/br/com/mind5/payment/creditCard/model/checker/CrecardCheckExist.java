package br.com.mind5.payment.creditCard.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.StdCrecardDaoSelect;

public final class CrecardCheckExist extends ModelCheckerTemplateActionV2<CrecardInfo, CrecardInfo> {	
	
	public CrecardCheckExist(ModelCheckerOption option) {
		super(option, CrecardInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<CrecardInfo> buildActionHook(DeciTreeOption<CrecardInfo> option) {
		ActionStdV1<CrecardInfo> select = new StdCrecardDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CREDIT_CARD_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_NOT_FOUND;
	}
}
