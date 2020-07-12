package br.com.mind5.business.person.model.checker;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.RootPerarchSelectEmail;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonCheckEmailTaken extends ModelCheckerTemplateActionV2<PersonInfo, PerarchInfo> {
	
	public PersonCheckEmailTaken(ModelCheckerOption option) {
		super(option, PerarchInfo.class);
	}
	 
	
	
	@Override protected ActionStdV1<PerarchInfo> buildActionHook(DeciTreeOption<PerarchInfo> option) {		
		ActionStdV1<PerarchInfo> select = new RootPerarchSelectEmail(option).toAction();		
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PERSON_EMAIL_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_EMAIL_NOT_FOUND;
	}
}
