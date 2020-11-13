package br.com.mind5.masterData.userCategory.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.userCategory.info.UseregInfo;
import br.com.mind5.masterData.userCategory.model.action.StdUseregDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class UseregCheckExist extends ModelCheckerTemplateActionV2<UseregInfo, UseregInfo> {
	
	public UseregCheckExist(ModelCheckerOption option) {
		super(option, UseregInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<UseregInfo> buildActionHook(DeciTreeOption<UseregInfo> option) {
		ActionStdV2<UseregInfo> select = new StdUseregDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_CATEG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_CATEG_NOT_FOUND;
	}
}
