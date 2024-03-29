package br.com.mind5.business.orderItemSearch.model.checker;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.model.decisionTree.OrdemarchRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdemarchCheckExist extends ModelCheckerTemplateAction<OrdemarchInfo, OrdemarchInfo> {
	
	public OrdemarchCheckExist(ModelCheckerOption option) {
		super(option, OrdemarchInfo.class);
	}
	

	
	@Override protected ActionStd<OrdemarchInfo> buildActionHook(DeciTreeOption<OrdemarchInfo> option) {
		ActionStd<OrdemarchInfo> select = new OrdemarchRootSelect(option).toAction();
		return select;
	}
	
	
		
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ORDER_ITEM_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ORDER_ITEM_SEARCH_NOT_FOUND;
	}
}
