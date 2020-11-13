package br.com.mind5.business.address.model.action;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddressMergeCountry extends ActionStdTemplate<AddressInfo> {

	public StdAddressMergeCountry(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<AddressInfo> buildVisitorHook(DeciTreeOption<AddressInfo> option) {
		return new VisiAddressMergeCountry(option);
	}
}
