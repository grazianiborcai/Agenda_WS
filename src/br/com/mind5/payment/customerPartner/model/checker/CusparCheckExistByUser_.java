package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparSelect;
import br.com.mind5.payment.customerPartner.model.action.StdCusparEnforceUserKey;

public final class CusparCheckExistByUser_ extends ModelCheckerTemplateActionV2<CusparInfo, CusparInfo> {
	
	public CusparCheckExistByUser_(ModelCheckerOption option) {
		super(option, CusparInfo.class);
	}
	

	
	@Override protected ActionStd<CusparInfo> buildActionHook(DeciTreeOption<CusparInfo> option) {
		ActionStd<CusparInfo> enforceUserKey = new StdCusparEnforceUserKey(option);
		ActionLazy<CusparInfo> select = new LazyCusparSelect(option.conn, option.schemaName);
		
		enforceUserKey.addPostAction(select);
		return enforceUserKey;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_CUS_USER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_USER_NOT_FOUND;
	}
}
