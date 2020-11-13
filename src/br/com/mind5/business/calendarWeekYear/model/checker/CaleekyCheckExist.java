package br.com.mind5.business.calendarWeekYear.model.checker;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.model.action.StdCaleekyDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CaleekyCheckExist extends ModelCheckerTemplateActionV2<CaleekyInfo, CaleekyInfo> {
	
	public CaleekyCheckExist(ModelCheckerOption option) {
		super(option, CaleekyInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<CaleekyInfo> buildActionHook(DeciTreeOption<CaleekyInfo> option) {
		ActionStdV2<CaleekyInfo> select = new StdCaleekyDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CAL_WEEK_YEAR_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CAL_WEEK_YEAR_NOT_FOUND;
	}
}
