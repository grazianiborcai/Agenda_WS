package br.com.mind5.masterData.timezone.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.masterData.timezone.model.action.TimezoneVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class TimezoneCheckExist extends ModelCheckerTemplateAction<TimezoneInfo, TimezoneInfo> {	
	
	public TimezoneCheckExist(ModelCheckerOption option) {
		super(option, TimezoneInfo.class);
	}
	
	
	
	@Override protected ActionStd<TimezoneInfo> buildActionHook(DeciTreeOption<TimezoneInfo> option) {
		ActionStd<TimezoneInfo> select = new ActionStdCommom<TimezoneInfo>(option, TimezoneVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.TIMEZONE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.TIMEZONE_NOT_FOUND;
	}
}
