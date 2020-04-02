package br.com.mind5.business.form.formPhone.model.checker;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.business.form.formPhone.model.action.StdFormPhoneSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FormPhoneCheckExist extends ModelCheckerTemplateAction<FormPhoneInfo, FormPhoneInfo> {
	
	public FormPhoneCheckExist(ModelCheckerOption option) {
		super(option, FormPhoneInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<FormPhoneInfo> buildActionHook(DeciTreeOption<FormPhoneInfo> option) {
		ActionStdV1<FormPhoneInfo> Select = new StdFormPhoneSelect(option);
		return Select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FORM_PHONE_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FORM_PHONE_NOT_FOUND;
	}
}
