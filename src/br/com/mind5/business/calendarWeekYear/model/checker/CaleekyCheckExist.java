package br.com.mind5.business.calendarWeekYear.model.checker;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.model.action.StdCaleekyDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CaleekyCheckExist extends ModelCheckerTemplateAction<CaleekyInfo, CaleekyInfo> {
	
	public CaleekyCheckExist(ModelCheckerOption option) {
		super(option, CaleekyInfo.class);
	}
	
	
	
	@Override protected ActionStd<CaleekyInfo> buildActionHook(DeciTreeOption<CaleekyInfo> option) {
		ActionStd<CaleekyInfo> select = new StdCaleekyDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CAL_WEEK_YEAR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CAL_WEEK_YEAR_NOT_FOUND;
	}
}
