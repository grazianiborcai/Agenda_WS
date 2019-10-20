package br.com.gda.payment.storePartner.model.checker;

import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.model.action.LazyStoparSelect;
import br.com.gda.payment.storePartner.model.action.StdStoparEnforceDel;

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
