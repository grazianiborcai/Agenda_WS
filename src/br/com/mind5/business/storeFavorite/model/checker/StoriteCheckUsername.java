package br.com.mind5.business.storeFavorite.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

public final class StoriteCheckUsername extends ModelCheckerTemplateActionV2<StoriteInfo, UsernameInfo> {
	
	public StoriteCheckUsername(ModelCheckerOption option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<UsernameInfo> buildActionHook(DeciTreeOption<UsernameInfo> option) {
		ActionStdV1<UsernameInfo> select = new RootUsernameSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_PASSWORD_AND_USERNAME_IS_VALID;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_PASSWORD_OR_USERNAME_IS_INVALID;
	}
}
