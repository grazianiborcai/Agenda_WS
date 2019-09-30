package br.com.gda.business.person.model.checker;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.action.StdPersonSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PersonCheckExist extends ModelCheckerTemplateActionV2<PersonInfo, PersonInfo> {
	
	public PersonCheckExist(ModelCheckerOption option) {
		super(option, PersonInfo.class);
	}
	
	
	
	@Override protected ActionStd<PersonInfo> buildActionHook(DeciTreeOption<PersonInfo> option) {
		ActionStd<PersonInfo> select = new StdPersonSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PERSON_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_NOT_FOUND;
	}
}
