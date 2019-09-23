package br.com.gda.business.phone.model.action;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.model.action.commom.ActionStdSuccessTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPhoneSuccess extends ActionStdSuccessTemplate<PhoneInfo> {

	public StdPhoneSuccess(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
}
