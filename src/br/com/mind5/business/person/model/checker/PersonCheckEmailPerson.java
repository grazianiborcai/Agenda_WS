package br.com.mind5.business.person.model.checker;

import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.personSearch.info.PerarchCopier;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.RootPerarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonCheckEmailPerson extends ModelCheckerTemplateActionV2<PersonInfo, PerarchInfo> {
	
	public PersonCheckEmailPerson(ModelCheckerOption option) {
		super(option, PerarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<PerarchInfo> buildActionHook(DeciTreeOption<PerarchInfo> option) {		
		ActionStd<PerarchInfo> select = new RootPerarchSelect(option).toAction();		
		return select;
	}
	
	
	
	@Override protected List<PerarchInfo> toActionClassHook(List<PersonInfo> recordInfos) {
		return PerarchCopier.copyFromPersonEmailChange(recordInfos);	
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PERSON_EMAIL_NOT_CHANGED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_EMAIL_CANT_BE_CHANGED;
	}
}
