package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhoneSuccess extends ActionStdSuccessTemplate<PhoneInfo> {

	public StdPhoneSuccess(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
}
