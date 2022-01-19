package br.com.mind5.business.petSearch.model.checker;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.decisionTree.RootPerarchSelectPersonEmp;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerarchCheckPersonEmp extends ModelCheckerTemplateAction<PetarchInfo, PetarchInfo> {
	
	public PerarchCheckPersonEmp(ModelCheckerOption option) {
		super(option, PetarchInfo.class);
	}
	

	
	@Override protected ActionStd<PetarchInfo> buildActionHook(DeciTreeOption<PetarchInfo> option) {		
		ActionStd<PetarchInfo> select = new RootPerarchSelectPersonEmp(option).toAction();			
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PERSON_SEARCH_IS_EMPLOYEE;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_SEARCH_EMPLOYEE_NOT_FOUND;
	}
}
