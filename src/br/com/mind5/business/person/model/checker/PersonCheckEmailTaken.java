package br.com.mind5.business.person.model.checker;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.PerarchRootSelectEmail;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonCheckEmailTaken extends ModelCheckerTemplateAction<PersonInfo, PerarchInfo> {
	
	public PersonCheckEmailTaken(ModelCheckerOption option) {
		super(option, PerarchInfo.class);
	}
	 
	
	
	@Override protected ActionStd<PerarchInfo> buildActionHook(DeciTreeOption<PerarchInfo> option) {		
		ActionStd<PerarchInfo> select = new PerarchRootSelectEmail(option).toAction();		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PERSON_EMAIL_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_EMAIL_NOT_FOUND;
	}
}
