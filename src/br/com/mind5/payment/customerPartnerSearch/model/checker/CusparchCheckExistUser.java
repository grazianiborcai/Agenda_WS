package br.com.mind5.payment.customerPartnerSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.decisionTree.RootCusparchSelectUser;

public final class CusparchCheckExistUser extends ModelCheckerTemplateAction<CusparchInfo, CusparchInfo> {
	
	public CusparchCheckExistUser(ModelCheckerOption option) {
		super(option, CusparchInfo.class);
	}
	

	
	@Override protected ActionStd<CusparchInfo> buildActionHook(DeciTreeOption<CusparchInfo> option) {
		ActionStd<CusparchInfo> select = new RootCusparchSelectUser(option).toAction();

		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_CUS_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_SEARCH_NOT_FOUND;
	}
}
