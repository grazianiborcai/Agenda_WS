package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.business.masterData.model.action.StdPayparSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PayparCheckExist extends ModelCheckerTemplateActionV2<PayparInfo, PayparInfo> {
	
	public PayparCheckExist(ModelCheckerOption option) {
		super(option, PayparInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<PayparInfo> buildActionHook(DeciTreeOption<PayparInfo> option) {
		ActionStdV1<PayparInfo> select = new StdPayparSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_NOT_FOUND;
	}
}
