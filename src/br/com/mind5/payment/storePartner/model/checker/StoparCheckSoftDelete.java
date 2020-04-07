package br.com.mind5.payment.storePartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
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
	
	
	
	@Override protected ActionStdV1<StoparInfo> buildActionHook(DeciTreeOption<StoparInfo> option) {
		ActionStdV1<StoparInfo> enforceDel = new StdStoparEnforceDel(option);
		ActionLazyV1<StoparInfo> select = new LazyStoparSelect(option.conn, option.schemaName);
		
		enforceDel.addPostAction(select);
		return enforceDel;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_PARTNER_STORE_FLAGGED_AS_DELETED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_PARTNER_STORE_NOT_FOUND;
	}
}
