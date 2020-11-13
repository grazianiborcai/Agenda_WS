package br.com.mind5.business.address.model.action;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddressDaoSelect extends ActionStdTemplate<AddressInfo> {

	public StdAddressDaoSelect(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<AddressInfo> buildVisitorHook(DeciTreeOption<AddressInfo> option) {
		return new VisiAddressDaoSelect(option);
	}
}
