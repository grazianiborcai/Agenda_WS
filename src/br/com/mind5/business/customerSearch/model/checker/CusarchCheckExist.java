package br.com.mind5.business.customerSearch.model.checker;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.decisionTree.RootCusarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusarchCheckExist extends ModelCheckerTemplateAction<CusarchInfo, CusarchInfo> {
	
	public CusarchCheckExist(ModelCheckerOption option) {
		super(option, CusarchInfo.class);
	}
	

	
	@Override protected ActionStdV1<CusarchInfo> buildActionHook(DeciTreeOption<CusarchInfo> option) {
		ActionStdV1<CusarchInfo> select = new RootCusarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CUSTOMER_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CUSTOMER_SEARCH_NOT_FOUND;
	}
}
