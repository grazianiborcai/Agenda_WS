package br.com.mind5.payment.creditCard.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardSelect;
import br.com.mind5.payment.creditCard.model.action.StdCrecardEnforceKeyId;

public final class CrecardCheckExistById extends ModelCheckerTemplateActionV2<CrecardInfo, CrecardInfo> {	
	
	public CrecardCheckExistById(ModelCheckerOption option) {
		super(option, CrecardInfo.class);
	}
	
	
	
	@Override protected ActionStd<CrecardInfo> buildActionHook(DeciTreeOption<CrecardInfo> option) {
		ActionStd<CrecardInfo> enforceKeyID = new StdCrecardEnforceKeyId(option);
		ActionLazy<CrecardInfo> select = new LazyCrecardSelect(option.conn, option.schemaName);
		
		enforceKeyID.addPostAction(select);
		return enforceKeyID;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CREDIT_CARD_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CREDIT_CARD_NOT_FOUND;
	}
}
