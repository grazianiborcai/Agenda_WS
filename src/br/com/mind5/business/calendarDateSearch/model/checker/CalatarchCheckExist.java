package br.com.mind5.business.calendarDateSearch.model.checker;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.business.calendarDateSearch.model.decisionTree.RootCalatarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalatarchCheckExist extends ModelCheckerTemplateActionV2<CalatarchInfo, CalatarchInfo> {
	
	public CalatarchCheckExist(ModelCheckerOption option) {
		super(option, CalatarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<CalatarchInfo> buildActionHook(DeciTreeOption<CalatarchInfo> option) {
		ActionStdV1<CalatarchInfo> select = new RootCalatarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CALENDAR_DATE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CALENDAR_DATE_NOT_FOUND;
	}
}
