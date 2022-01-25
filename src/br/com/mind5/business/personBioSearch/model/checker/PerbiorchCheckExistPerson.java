package br.com.mind5.business.personBioSearch.model.checker;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSearch.model.decisionTree.RootPerbiorchSelectPerson;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbiorchCheckExistPerson extends ModelCheckerTemplateAction<PerbiorchInfo, PerbiorchInfo> {
	
	public PerbiorchCheckExistPerson(ModelCheckerOption option) {
		super(option, PerbiorchInfo.class);
	}
	

	
	@Override protected ActionStd<PerbiorchInfo> buildActionHook(DeciTreeOption<PerbiorchInfo> option) {		
		ActionStd<PerbiorchInfo> select = new RootPerbiorchSelectPerson(option).toAction();			
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PERSON_BIO_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_BIO_SEARCH_NOT_FOUND;
	}
}
