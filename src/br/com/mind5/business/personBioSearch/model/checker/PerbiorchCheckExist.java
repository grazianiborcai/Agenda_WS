package br.com.mind5.business.personBioSearch.model.checker;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSearch.model.decisionTree.PerbiorchRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbiorchCheckExist extends ModelCheckerTemplateAction<PerbiorchInfo, PerbiorchInfo> {
	
	public PerbiorchCheckExist(ModelCheckerOption option) {
		super(option, PerbiorchInfo.class);
	}
	

	
	@Override protected ActionStd<PerbiorchInfo> buildActionHook(DeciTreeOption<PerbiorchInfo> option) {		
		ActionStd<PerbiorchInfo> select = new PerbiorchRootSelect(option).toAction();			
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PERSON_BIO_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PERSON_BIO_SEARCH_NOT_FOUND;
	}
}
