package br.com.mind5.business.phone.model.checker;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.action.PhoneVisiDaoSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneCheckExist extends ModelCheckerTemplateAction<PhoneInfo, PhoneInfo> {
	
	public PhoneCheckExist(ModelCheckerOption option) {
		super(option, PhoneInfo.class);
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> buildActionHook(DeciTreeOption<PhoneInfo> option) {
		ActionStd<PhoneInfo> actionSelect = new ActionStdCommom<PhoneInfo>(option, PhoneVisiDaoSelect.class);
		return actionSelect;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PHONE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_NOT_FOUND;
	}
}
