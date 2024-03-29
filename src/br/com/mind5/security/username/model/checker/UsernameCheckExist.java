package br.com.mind5.security.username.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.action.UsernameVisiDaoSelect;

public final class UsernameCheckExist extends ModelCheckerTemplateAction<UsernameInfo, UsernameInfo> {
	
	public UsernameCheckExist(ModelCheckerOption option) {
		super(option, UsernameInfo.class);
	}
	

	
	@Override protected ActionStd<UsernameInfo> buildActionHook(DeciTreeOption<UsernameInfo> option) {		
		ActionStd<UsernameInfo> Select = new ActionStdCommom<UsernameInfo>(option, UsernameVisiDaoSelect.class);
		return Select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USERNAME_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USERNAME_NOT_FOUND;
	}
}
