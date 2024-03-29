package br.com.mind5.business.phoneDefault.model.checker;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneDefault.model.decisionTree.PhonaultRootSelectUser;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonaultCheckExistUser extends ModelCheckerTemplateAction<PhonaultInfo, PhonaultInfo> {
	
	public PhonaultCheckExistUser(ModelCheckerOption option) {
		super(option, PhonaultInfo.class);
	}
	
	
	
	@Override protected ActionStd<PhonaultInfo> buildActionHook(DeciTreeOption<PhonaultInfo> option) {
		ActionStd<PhonaultInfo> select = new PhonaultRootSelectUser(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PHONE_DEFAULT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_DEFAULT_NOT_FOUND;
	}
}
