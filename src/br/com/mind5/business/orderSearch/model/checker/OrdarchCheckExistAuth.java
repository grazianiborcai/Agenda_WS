package br.com.mind5.business.orderSearch.model.checker;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.decisionTree.RootOrdarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdarchCheckExistAuth extends ModelCheckerTemplateAction<OrdarchInfo, OrdarchInfo> {
	
	public OrdarchCheckExistAuth(ModelCheckerOption option) {
		super(option, OrdarchInfo.class);
	}
	

	
	@Override protected ActionStd<OrdarchInfo> buildActionHook(DeciTreeOption<OrdarchInfo> option) {		
		ActionStd<OrdarchInfo> select = new RootOrdarchSelect(option).toAction();			
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ORDER_SEARCH_ALREADY_EXIST_AUTH;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_SEARCH_NOT_FOUND_AUTH;
	}
}
