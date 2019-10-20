package br.com.gda.payment.storePartner.model.checker;

import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.model.decisionTree.RootStoparSelect;

public final class StoparCheckExist extends ModelCheckerTemplateActionV2<StoparInfo, StoparInfo> {
	
	public StoparCheckExist(ModelCheckerOption option) {
		super(option, StoparInfo.class);
	}
	

	
	@Override protected ActionStd<StoparInfo> buildActionHook(DeciTreeOption<StoparInfo> option) {
		ActionStd<StoparInfo> select = new RootStoparSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_STORE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_STORE_NOT_FOUND;
	}
}
