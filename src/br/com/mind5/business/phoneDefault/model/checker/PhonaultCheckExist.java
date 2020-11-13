package br.com.mind5.business.phoneDefault.model.checker;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.business.phoneDefault.model.decisionTree.RootPhonaultSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonaultCheckExist extends ModelCheckerTemplateActionV2<PhonaultInfo, PhonaultInfo> {
	
	public PhonaultCheckExist(ModelCheckerOption option) {
		super(option, PhonaultInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<PhonaultInfo> buildActionHook(DeciTreeOption<PhonaultInfo> option) {
		ActionStdV2<PhonaultInfo> select = new RootPhonaultSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PHONE_DEFAULT_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PHONE_DEFAULT_NOT_FOUND;
	}
}
