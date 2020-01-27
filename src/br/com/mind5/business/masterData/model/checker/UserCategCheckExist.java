package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.UserCategInfo;
import br.com.mind5.business.masterData.model.action.StdUserCategSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class UserCategCheckExist extends ModelCheckerTemplateActionV2<UserCategInfo, UserCategInfo> {
	
	public UserCategCheckExist(ModelCheckerOption option) {
		super(option, UserCategInfo.class);
	}
	
	
	
	@Override protected ActionStd<UserCategInfo> buildActionHook(DeciTreeOption<UserCategInfo> option) {
		ActionStd<UserCategInfo> select = new StdUserCategSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_CATEG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_CATEG_NOT_FOUND;
	}
}
