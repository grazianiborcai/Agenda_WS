package br.com.mind5.masterData.moonPhase.model.checker;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.action.StdMoonaseDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MoonaseCheckExist extends ModelCheckerTemplateActionV2<MoonaseInfo, MoonaseInfo> {
	
	public MoonaseCheckExist(ModelCheckerOption option) {
		super(option, MoonaseInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<MoonaseInfo> buildActionHook(DeciTreeOption<MoonaseInfo> option) {
		ActionStdV2<MoonaseInfo> select = new StdMoonaseDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MOON_PHASE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MOON_PHASE_NOT_FOUND;
	}
}
