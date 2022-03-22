package br.com.mind5.business.customerSearch.model.checker;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.decisionTree.CusarchRootSelectUser;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusarchCheckExistUser extends ModelCheckerTemplateAction<CusarchInfo, CusarchInfo> {
	
	public CusarchCheckExistUser(ModelCheckerOption option) {
		super(option, CusarchInfo.class);
	}
	

	
	@Override protected ActionStd<CusarchInfo> buildActionHook(DeciTreeOption<CusarchInfo> option) {
		ActionStd<CusarchInfo> select = new CusarchRootSelectUser(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CUSTOMER_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CUSTOMER_SEARCH_NOT_FOUND;
	}
}
