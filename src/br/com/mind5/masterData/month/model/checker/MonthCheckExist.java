package br.com.mind5.masterData.month.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.action.MonthVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MonthCheckExist extends ModelCheckerTemplateAction<MonthInfo, MonthInfo> {
	
	public MonthCheckExist(ModelCheckerOption option) {
		super(option, MonthInfo.class);
	}
	
	
	
	@Override protected ActionStd<MonthInfo> buildActionHook(DeciTreeOption<MonthInfo> option) {
		ActionStd<MonthInfo> select = new ActionStdCommom<MonthInfo>(option, MonthVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MONTH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MONTH_NOT_FOUND;
	}
}
