package br.com.mind5.business.phone.model.checker;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.action.StdPhoneSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
