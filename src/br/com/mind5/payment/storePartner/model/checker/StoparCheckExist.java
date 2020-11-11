package br.com.mind5.payment.storePartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.action.StdStoparDaoSelect;

public final class StoparCheckExist extends ModelCheckerTemplateActionV2<StoparInfo, StoparInfo> {
	
	public StoparCheckExist(ModelCheckerOption option) {
		super(option, StoparInfo.class);
	}
	

	
	@Override protected ActionStdV1<StoparInfo> buildActionHook(DeciTreeOption<StoparInfo> option) {
		ActionStdV1<StoparInfo> select = new StdStoparDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_STORE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_STORE_NOT_FOUND;
	}
}
