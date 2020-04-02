package br.com.mind5.business.person.model.checker;

import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.personSearch.info.PerarchCopier;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.RootPerarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonCheckCpfPerson extends ModelCheckerTemplateAction<PersonInfo, PerarchInfo> {
	
	public PersonCheckCpfPerson(ModelCheckerOption option) {
		super(option, PerarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<PerarchInfo> buildActionHook(DeciTreeOption<PerarchInfo> option) {		
		ActionStdV1<PerarchInfo> select = new RootPerarchSelect(option).toAction();		
		return select;
	}
	
	
	
	@Override protected List<PerarchInfo> toActionClassHook(List<PersonInfo> recordInfos) {
		return PerarchCopier.copyFromPersonCpfChange(recordInfos);	
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PERSON_CPF_NOT_CHANGED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_CPF_CANT_BE_CHANGED;
	}
}
