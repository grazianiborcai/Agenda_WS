package br.com.mind5.security.userPasswordSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;
import br.com.mind5.security.userPasswordSearch.model.decisionTree.RootUpswdarchChangedBefore;

public final class UpswdarchCheckChangedBefore extends ModelCheckerTemplateAction<UpswdarchInfo, UpswdarchInfo> {
	
	public UpswdarchCheckChangedBefore(ModelCheckerOption option) {
		super(option, UpswdarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<UpswdarchInfo> buildActionHook(DeciTreeOption<UpswdarchInfo> option) {
		ActionStd<UpswdarchInfo> select = new RootUpswdarchChangedBefore(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.USER_PASSWORD_SEARCH_NOT_CHANGED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.USER_PASSWORD_SEARCH_CHANGED;
	}
}
