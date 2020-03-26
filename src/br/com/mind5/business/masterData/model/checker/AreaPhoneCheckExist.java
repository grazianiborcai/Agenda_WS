package br.com.mind5.business.masterData.model.checker;

import br.com.mind5.business.masterData.info.AreaPhoneInfo;
import br.com.mind5.business.masterData.model.action.StdAreaPhoneSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AreaPhoneCheckExist extends ModelCheckerTemplateAction<AreaPhoneInfo, AreaPhoneInfo> {
	
	public AreaPhoneCheckExist(ModelCheckerOption option) {
		super(option, AreaPhoneInfo.class);
	}
	
	
	
	@Override protected ActionStd<AreaPhoneInfo> buildActionHook(DeciTreeOption<AreaPhoneInfo> option) {
		ActionStd<AreaPhoneInfo> select = new StdAreaPhoneSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.AREA_PHONE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.AREA_PHONE_NOT_FOUND;
	}
}
