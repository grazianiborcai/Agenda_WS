package br.com.mind5.masterData.userCategory.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.userCategory.info.UseregInfo;
import br.com.mind5.masterData.userCategory.model.action.StdUseregDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class UseregCheckExist extends ModelCheckerTemplateAction<UseregInfo, UseregInfo> {
	
	public UseregCheckExist(ModelCheckerOption option) {
		super(option, UseregInfo.class);
	}
	
	
	
	@Override protected ActionStd<UseregInfo> buildActionHook(DeciTreeOption<UseregInfo> option) {
		ActionStd<UseregInfo> select = new StdUseregDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_CATEG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_CATEG_NOT_FOUND;
	}
}
