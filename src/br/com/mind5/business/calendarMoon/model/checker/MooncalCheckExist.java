package br.com.mind5.business.calendarMoon.model.checker;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.business.calendarMoon.model.action.StdMooncalDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MooncalCheckExist extends ModelCheckerTemplateActionV2<MooncalInfo, MooncalInfo> {
	
	public MooncalCheckExist(ModelCheckerOption option) {
		super(option, MooncalInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MooncalInfo> buildActionHook(DeciTreeOption<MooncalInfo> option) {
		ActionStdV1<MooncalInfo> select = new StdMooncalDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MOON_CALENDAR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MOON_CALENDAR_NOT_FOUND;
	}
}
