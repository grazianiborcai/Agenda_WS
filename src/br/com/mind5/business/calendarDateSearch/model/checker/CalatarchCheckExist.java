package br.com.mind5.business.calendarDateSearch.model.checker;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.business.calendarDateSearch.model.decisionTree.RootCalatarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalatarchCheckExist extends ModelCheckerTemplateAction<CalatarchInfo, CalatarchInfo> {
	
	public CalatarchCheckExist(ModelCheckerOption option) {
		super(option, CalatarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<CalatarchInfo> buildActionHook(DeciTreeOption<CalatarchInfo> option) {
		ActionStd<CalatarchInfo> select = new RootCalatarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CALENDAR_DATE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CALENDAR_DATE_NOT_FOUND;
	}
}
