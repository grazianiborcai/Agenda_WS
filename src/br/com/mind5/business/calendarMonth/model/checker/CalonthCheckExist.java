package br.com.mind5.business.calendarMonth.model.checker;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.action.CalonthVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalonthCheckExist extends ModelCheckerTemplateAction<CalonthInfo, CalonthInfo> {
	
	public CalonthCheckExist(ModelCheckerOption option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected ActionStd<CalonthInfo> buildActionHook(DeciTreeOption<CalonthInfo> option) {
		ActionStd<CalonthInfo> select = new ActionStdCommom<CalonthInfo>(option, CalonthVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CALENDAR_MONTH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CALENDAR_MONTH_NOT_FOUND;
	}
}
