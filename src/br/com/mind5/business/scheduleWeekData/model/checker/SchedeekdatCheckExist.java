package br.com.mind5.business.scheduleWeekData.model.checker;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.scheduleWeekData.model.action.SchedeekdatVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedeekdatCheckExist extends ModelCheckerTemplateAction<SchedeekdatInfo, SchedeekdatInfo> {
	
	public SchedeekdatCheckExist(ModelCheckerOption option) {
		super(option, SchedeekdatInfo.class);
	}
	
	
	
	@Override protected ActionStd<SchedeekdatInfo> buildActionHook(DeciTreeOption<SchedeekdatInfo> option) {
		ActionStd<SchedeekdatInfo> select = new ActionStdCommom<SchedeekdatInfo>(option, SchedeekdatVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SCHEDULE_WEEK_DATA_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_WEEK_DATA_NOT_FOUND;
	}
}
