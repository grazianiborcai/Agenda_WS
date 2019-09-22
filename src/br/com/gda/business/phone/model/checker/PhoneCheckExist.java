package br.com.gda.business.phone.model.checker;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.StdPhoneSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PhoneCheckExist extends ModelCheckerTemplateActionV2<PhoneInfo, PhoneInfo> {
	
	public PhoneCheckExist(ModelCheckerOption option) {
		super(option, PhoneInfo.class);
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> buildActionHook(DeciTreeOption<PhoneInfo> option) {
		ActionStd<PhoneInfo> actionSelect = new StdPhoneSelect(option);
		return actionSelect;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PHONE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_NOT_FOUND;
	}
}
