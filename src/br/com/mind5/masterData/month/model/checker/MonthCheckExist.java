package br.com.mind5.masterData.month.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.action.StdMonthDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MonthCheckExist extends ModelCheckerTemplateActionV2<MonthInfo, MonthInfo> {
	
	public MonthCheckExist(ModelCheckerOption option) {
		super(option, MonthInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<MonthInfo> buildActionHook(DeciTreeOption<MonthInfo> option) {
		ActionStdV1<MonthInfo> select = new StdMonthDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MONTH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MONTH_NOT_FOUND;
	}
}
