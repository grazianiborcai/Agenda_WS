package br.com.mind5.masterData.weekday.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.action.StdWeekdayDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class WeekdayCheckExist extends ModelCheckerTemplateAction<WeekdayInfo, WeekdayInfo> {
	
	public WeekdayCheckExist(ModelCheckerOption option) {
		super(option, WeekdayInfo.class);
	}
	
	
	
	@Override protected ActionStd<WeekdayInfo> buildActionHook(DeciTreeOption<WeekdayInfo> option) {
		ActionStd<WeekdayInfo> select = new StdWeekdayDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.WEEKDAY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.WEEKDAY_NOT_FOUND;
	}
}
