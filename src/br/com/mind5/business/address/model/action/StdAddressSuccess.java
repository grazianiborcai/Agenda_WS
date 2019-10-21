package br.com.mind5.business.address.model.action;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddressSuccess extends ActionStdSuccessTemplate<AddressInfo> {
	public StdAddressSuccess(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
}
