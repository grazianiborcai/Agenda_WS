package br.com.gda.business.address.model.action;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.model.action.commom.ActionStdSuccessTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdAddressSuccess extends ActionStdSuccessTemplate<AddressInfo> {
	public StdAddressSuccess(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
}
