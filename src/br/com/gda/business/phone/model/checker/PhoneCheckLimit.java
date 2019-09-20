package br.com.gda.business.phone.model.checker;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.action.StdPhoneSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PhoneCheckLimit extends ModelCheckerTemplateActionV2<PhoneInfo, PhoneInfo> {
	private final int MAX_RECORD_COUNT = 10;
	
	
	public PhoneCheckLimit(ModelCheckerOption option) {
		super(option, PhoneInfo.class);
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> buildActionHook(DeciTreeOption<PhoneInfo> option) {
		ActionStd<PhoneInfo> select = new StdPhoneSelect(option);
		return select;
	}
	
	
	
	@Override protected int getMaxCountHook() {
		return MAX_RECORD_COUNT;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PHONE_LIMIT_NOT_REACHED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_LIMIT_EXCEEDED;
	}
}
