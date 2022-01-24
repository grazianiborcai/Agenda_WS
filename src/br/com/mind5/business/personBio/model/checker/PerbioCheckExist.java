package br.com.mind5.business.personBio.model.checker;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.model.action.StdPerbioDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbioCheckExist extends ModelCheckerTemplateAction<PerbioInfo, PerbioInfo> {	
	
	public PerbioCheckExist(ModelCheckerOption option) {
		super(option, PerbioInfo.class);
	}
	
	
	
	@Override protected ActionStd<PerbioInfo> buildActionHook(DeciTreeOption<PerbioInfo> option) {
		ActionStd<PerbioInfo> select = new StdPerbioDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PET_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_NOT_FOUND;
	}
}
