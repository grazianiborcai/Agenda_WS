package br.com.mind5.business.addressSnapshot.model.action;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddresnapSuccess extends ActionStdSuccessTemplate<AddresnapInfo>{

	public StdAddresnapSuccess(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
}
