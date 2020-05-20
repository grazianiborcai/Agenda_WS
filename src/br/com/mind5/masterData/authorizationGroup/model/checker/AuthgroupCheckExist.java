package br.com.mind5.masterData.authorizationGroup.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.authorizationGroup.info.AuthgroupInfo;
import br.com.mind5.masterData.authorizationGroup.model.action.StdAuthgroupDaoSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AuthgroupCheckExist extends ModelCheckerTemplateActionV2<AuthgroupInfo, AuthgroupInfo> {
	
	public AuthgroupCheckExist(ModelCheckerOption option) {
		super(option, AuthgroupInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<AuthgroupInfo> buildActionHook(DeciTreeOption<AuthgroupInfo> option) {
		ActionStdV1<AuthgroupInfo> select = new StdAuthgroupDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.AUTH_GROUP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.AUTH_GROUP_NOT_FOUND;
	}
}
