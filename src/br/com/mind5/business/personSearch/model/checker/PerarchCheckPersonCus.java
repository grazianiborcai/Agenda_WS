package br.com.mind5.business.personSearch.model.checker;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.PerarchRootSelectPersonCus;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerarchCheckPersonCus extends ModelCheckerTemplateAction<PerarchInfo, PerarchInfo> {
	
	public PerarchCheckPersonCus(ModelCheckerOption option) {
		super(option, PerarchInfo.class);
	}
	

	
	@Override protected ActionStd<PerarchInfo> buildActionHook(DeciTreeOption<PerarchInfo> option) {		
		ActionStd<PerarchInfo> select = new PerarchRootSelectPersonCus(option).toAction();			
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PERSON_SEARCH_IS_CUSTOMER;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_SEARCH_CUSTOMER_NOT_FOUND;
	}
}
