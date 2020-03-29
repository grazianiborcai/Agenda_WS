package br.com.mind5.masterData.moonPhase.model.checker;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.action.StdMoonaseSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MoonaseCheckExist extends ModelCheckerTemplateAction<MoonaseInfo, MoonaseInfo> {
	
	public MoonaseCheckExist(ModelCheckerOption option) {
		super(option, MoonaseInfo.class);
	}
	
	
	
	@Override protected ActionStd<MoonaseInfo> buildActionHook(DeciTreeOption<MoonaseInfo> option) {
		ActionStd<MoonaseInfo> select = new StdMoonaseSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MOON_PHASE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MOON_PHASE_NOT_FOUND;
	}
}
