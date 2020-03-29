package br.com.mind5.business.calendarDate.model.checker;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.action.StdCalateSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalateCheckExist extends ModelCheckerTemplateAction<CalateInfo, CalateInfo> {
	
	public CalateCheckExist(ModelCheckerOption option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected ActionStd<CalateInfo> buildActionHook(DeciTreeOption<CalateInfo> option) {
		ActionStd<CalateInfo> select = new StdCalateSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CALENDAR_DATE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CALENDAR_DATE_NOT_FOUND;
	}
}
