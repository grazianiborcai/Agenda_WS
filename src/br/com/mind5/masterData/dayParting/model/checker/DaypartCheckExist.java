package br.com.mind5.masterData.dayParting.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.dayParting.model.action.StdDaypartDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DaypartCheckExist extends ModelCheckerTemplateActionV2<DaypartInfo, DaypartInfo> {
	
	public DaypartCheckExist(ModelCheckerOption option) {
		super(option, DaypartInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<DaypartInfo> buildActionHook(DeciTreeOption<DaypartInfo> option) {
		ActionStdV2<DaypartInfo> select = new StdDaypartDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.DAYPART_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.DAYPART_NOT_FOUND;
	}
}
