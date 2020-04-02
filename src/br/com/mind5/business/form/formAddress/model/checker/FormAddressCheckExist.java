package br.com.mind5.business.form.formAddress.model.checker;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.business.form.formAddress.model.action.StdFormAddressSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FormAddressCheckExist extends ModelCheckerTemplateAction<FormAddressInfo, FormAddressInfo> {
	
	public FormAddressCheckExist(ModelCheckerOption option) {
		super(option, FormAddressInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<FormAddressInfo> buildActionHook(DeciTreeOption<FormAddressInfo> option) {
		ActionStdV1<FormAddressInfo> select = new StdFormAddressSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FORM_ADDRESS_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FORM_ADDRESS_NOT_FOUND;
	}
}
