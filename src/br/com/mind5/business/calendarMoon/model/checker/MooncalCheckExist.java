package br.com.mind5.business.calendarMoon.model.checker;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.business.calendarMoon.model.action.MooncalVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MooncalCheckExist extends ModelCheckerTemplateAction<MooncalInfo, MooncalInfo> {
	
	public MooncalCheckExist(ModelCheckerOption option) {
		super(option, MooncalInfo.class);
	}
	
	
	
	@Override protected ActionStd<MooncalInfo> buildActionHook(DeciTreeOption<MooncalInfo> option) {
		ActionStd<MooncalInfo> select = new ActionStdCommom<MooncalInfo>(option, MooncalVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MOON_CALENDAR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MOON_CALENDAR_NOT_FOUND;
	}
}
