package br.com.mind5.payment.storePartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.action.LazyStoparSelect;
import br.com.mind5.payment.storePartner.model.action.StdStoparEnforceDel;

public final class StoparCheckSoftDelete extends ModelCheckerTemplateActionV2<StoparInfo, StoparInfo> {
	
	public StoparCheckSoftDelete(ModelCheckerOption option) {
		super(option, StoparInfo.class);
	}
	
	
	
	@Override protected ActionStd<StoparInfo> buildActionHook(DeciTreeOption<StoparInfo> option) {
		ActionStd<StoparInfo> actionSelect = new StdStoparEnforceDel(option);
		actionSelect.addPostAction(new LazyStoparSelect(option.conn, option.schemaName));		
		return actionSelect;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_STORE_FLAGGED_AS_DELETED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_STORE_NOT_FOUND;
	}
}
