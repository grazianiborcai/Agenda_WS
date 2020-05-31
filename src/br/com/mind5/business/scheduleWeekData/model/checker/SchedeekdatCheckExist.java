package br.com.mind5.business.scheduleWeekData.model.checker;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.scheduleWeekData.model.action.StdSchedeekdatDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedeekdatCheckExist extends ModelCheckerTemplateActionV2<SchedeekdatInfo, SchedeekdatInfo> {
	
	public SchedeekdatCheckExist(ModelCheckerOption option) {
		super(option, SchedeekdatInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<SchedeekdatInfo> buildActionHook(DeciTreeOption<SchedeekdatInfo> option) {
		ActionStdV1<SchedeekdatInfo> select = new StdSchedeekdatDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_WEEK_DATA_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_WEEK_DATA_NOT_FOUND;
	}
}
