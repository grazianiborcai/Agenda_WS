package br.com.mind5.masterData.weekday.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.action.StdWeekdayDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class WeekdayCheckExist extends ModelCheckerTemplateActionV2<WeekdayInfo, WeekdayInfo> {
	
	public WeekdayCheckExist(ModelCheckerOption option) {
		super(option, WeekdayInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<WeekdayInfo> buildActionHook(DeciTreeOption<WeekdayInfo> option) {
		ActionStdV2<WeekdayInfo> select = new StdWeekdayDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.WEEKDAY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.WEEKDAY_NOT_FOUND;
	}
}
