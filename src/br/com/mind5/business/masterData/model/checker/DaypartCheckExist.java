package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.DaypartInfo;
import br.com.mind5.business.masterData.model.action.StdDaypartSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DaypartCheckExist extends ModelCheckerTemplateAction<DaypartInfo, DaypartInfo> {
	
	public DaypartCheckExist(ModelCheckerOption option) {
		super(option, DaypartInfo.class);
	}
	
	
	
	@Override protected ActionStd<DaypartInfo> buildActionHook(DeciTreeOption<DaypartInfo> option) {
		ActionStd<DaypartInfo> select = new StdDaypartSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.DAYPART_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DAYPART_NOT_FOUND;
	}
}
