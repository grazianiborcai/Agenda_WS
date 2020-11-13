package br.com.mind5.masterData.paymentPartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.masterData.paymentPartner.model.action.StdPayparDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayparCheckExist extends ModelCheckerTemplateActionV2<PayparInfo, PayparInfo> {
	
	public PayparCheckExist(ModelCheckerOption option) {
		super(option, PayparInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<PayparInfo> buildActionHook(DeciTreeOption<PayparInfo> option) {
		ActionStdV2<PayparInfo> select = new StdPayparDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_NOT_FOUND;
	}
}
