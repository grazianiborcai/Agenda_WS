package br.com.mind5.payment.customerPartnerSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.decisionTree.RootCusparchSelect;

public final class CusparchCheckExist extends ModelCheckerTemplateAction<CusparchInfo, CusparchInfo> {
	
	public CusparchCheckExist(ModelCheckerOption option) {
		super(option, CusparchInfo.class);
	}
	

	
	@Override protected ActionStdV1<CusparchInfo> buildActionHook(DeciTreeOption<CusparchInfo> option) {
		ActionStdV1<CusparchInfo> select = new RootCusparchSelect(option).toAction();

		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PAY_CUS_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PAY_CUS_SEARCH_NOT_FOUND;
	}
}
