package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.AuthGroupInfo;
import br.com.mind5.business.masterData.model.action.StdAuthGroupSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AuthGroupCheckExist extends ModelCheckerTemplateActionV2<AuthGroupInfo, AuthGroupInfo> {
	
	public AuthGroupCheckExist(ModelCheckerOption option) {
		super(option, AuthGroupInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<AuthGroupInfo> buildActionHook(DeciTreeOption<AuthGroupInfo> option) {
		ActionStdV1<AuthGroupInfo> select = new StdAuthGroupSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.AUTH_GROUP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.AUTH_GROUP_NOT_FOUND;
	}
}
