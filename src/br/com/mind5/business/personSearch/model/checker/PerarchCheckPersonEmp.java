package br.com.mind5.business.personSearch.model.checker;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.RootPerarchSelectPersonEmp;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerarchCheckPersonEmp extends ModelCheckerTemplateActionV2<PerarchInfo, PerarchInfo> {
	
	public PerarchCheckPersonEmp(ModelCheckerOption option) {
		super(option, PerarchInfo.class);
	}
	

	
	@Override protected ActionStdV1<PerarchInfo> buildActionHook(DeciTreeOption<PerarchInfo> option) {		
		ActionStdV1<PerarchInfo> select = new RootPerarchSelectPersonEmp(option).toAction();			
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PERSON_SEARCH_IS_EMPLOYEE;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_SEARCH_EMPLOYEE_NOT_FOUND;
	}
}
