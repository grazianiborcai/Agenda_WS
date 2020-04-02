package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.masterData.model.action.StdTimezoneSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class TimezoneCheckExist extends ModelCheckerTemplateAction<TimezoneInfo, TimezoneInfo> {	
	
	public TimezoneCheckExist(ModelCheckerOption option) {
		super(option, TimezoneInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<TimezoneInfo> buildActionHook(DeciTreeOption<TimezoneInfo> option) {
		ActionStdV1<TimezoneInfo> select = new StdTimezoneSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.TIMEZONE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.TIMEZONE_NOT_FOUND;
	}
}
