package br.com.mind5.security.username.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.action.StdUsernameDaoSelect;

public final class UsernameCheckExist extends ModelCheckerTemplateActionV2<UsernameInfo, UsernameInfo> {
	
	public UsernameCheckExist(ModelCheckerOption option) {
		super(option, UsernameInfo.class);
	}
	

	
	@Override protected ActionStdV1<UsernameInfo> buildActionHook(DeciTreeOption<UsernameInfo> option) {		
		ActionStdV1<UsernameInfo> Select = new StdUsernameDaoSelect(option);
		return Select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USERNAME_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USERNAME_NOT_FOUND;
	}
}
