package br.com.mind5.business.scheduleDayData.model.checker;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.scheduleDayData.model.action.StdSchedaytaDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedaytaCheckExist extends ModelCheckerTemplateAction<SchedaytaInfo, SchedaytaInfo> {
	
	public SchedaytaCheckExist(ModelCheckerOption option) {
		super(option, SchedaytaInfo.class);
	}
	
	
	
	@Override protected ActionStd<SchedaytaInfo> buildActionHook(DeciTreeOption<SchedaytaInfo> option) {
		ActionStd<SchedaytaInfo> select = new StdSchedaytaDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_DAY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_DAY_NOT_FOUND;
	}
}
