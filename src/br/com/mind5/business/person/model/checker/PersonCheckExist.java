package br.com.mind5.business.person.model.checker;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.StdPersonDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonCheckExist extends ModelCheckerTemplateActionV2<PersonInfo, PersonInfo> {
	
	public PersonCheckExist(ModelCheckerOption option) {
		super(option, PersonInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<PersonInfo> buildActionHook(DeciTreeOption<PersonInfo> option) {
		ActionStdV2<PersonInfo> select = new StdPersonDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PERSON_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_NOT_FOUND;
	}
}
