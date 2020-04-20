package br.com.mind5.masterData.timezone.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.masterData.timezone.model.action.StdTimezoneDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class TimezoneCheckExist extends ModelCheckerTemplateActionV2<TimezoneInfo, TimezoneInfo> {	
	
	public TimezoneCheckExist(ModelCheckerOption option) {
		super(option, TimezoneInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<TimezoneInfo> buildActionHook(DeciTreeOption<TimezoneInfo> option) {
		ActionStdV1<TimezoneInfo> select = new StdTimezoneDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.TIMEZONE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.TIMEZONE_NOT_FOUND;
	}
}