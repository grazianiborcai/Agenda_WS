package br.com.mind5.business.phoneSearch.model.checker;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.decisionTree.PhonarchRootSelectUser;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonarchCheckExistUser extends ModelCheckerTemplateAction<PhonarchInfo, PhonarchInfo> {
	
	public PhonarchCheckExistUser(ModelCheckerOption option) {
		super(option, PhonarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<PhonarchInfo> buildActionHook(DeciTreeOption<PhonarchInfo> option) {
		ActionStd<PhonarchInfo> select = new PhonarchRootSelectUser(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PHONE_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_SEARCH_NOT_FOUND;
	}
}
