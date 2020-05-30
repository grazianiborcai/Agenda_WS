package br.com.mind5.business.calendarDate.model.checker;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.action.StdCalateDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalateCheckExist extends ModelCheckerTemplateActionV2<CalateInfo, CalateInfo> {
	
	public CalateCheckExist(ModelCheckerOption option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<CalateInfo> buildActionHook(DeciTreeOption<CalateInfo> option) {
		ActionStdV1<CalateInfo> select = new StdCalateDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CALENDAR_DATE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CALENDAR_DATE_NOT_FOUND;
	}
}
