package br.com.mind5.business.scheduleDayData.model.checker;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.scheduleDayData.model.action.StdSchedaytaDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedaytaCheckExist extends ModelCheckerTemplateActionV2<SchedaytaInfo, SchedaytaInfo> {
	
	public SchedaytaCheckExist(ModelCheckerOption option) {
		super(option, SchedaytaInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<SchedaytaInfo> buildActionHook(DeciTreeOption<SchedaytaInfo> option) {
		ActionStdV2<SchedaytaInfo> select = new StdSchedaytaDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_DAY_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_DAY_NOT_FOUND;
	}
}
