package br.com.gda.business.addressSnapshot.model.action;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.model.action.commom.ActionStdSuccessTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdAddresnapSuccess extends ActionStdSuccessTemplate<AddresnapInfo> {

	public StdAddresnapSuccess(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
}
