package br.com.mind5.business.phone.model.checker;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phoneSearch.info.PhonarchCopier;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSearch.model.decisionTree.PhonarchRootSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhoneCheckLimit extends ModelCheckerTemplateAction<PhoneInfo, PhonarchInfo> {
	private final int MAX_RECORD_COUNT = 10;
	
	
	public PhoneCheckLimit(ModelCheckerOption option) {
		super(option, PhonarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<PhonarchInfo> buildActionHook(DeciTreeOption<PhonarchInfo> option) {
		ActionStd<PhonarchInfo> select = new PhonarchRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<PhonarchInfo> toActionClassHook(List<PhoneInfo> recordInfos) {
		return PhonarchCopier.copyFromPhoneRef(recordInfos);	
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
