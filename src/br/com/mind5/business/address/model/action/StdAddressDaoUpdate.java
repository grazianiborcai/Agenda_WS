package br.com.mind5.business.address.model.action;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddressDaoUpdate extends ActionStdTemplateV2<AddressInfo>{

	public StdAddressDaoUpdate(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<AddressInfo> buildVisitorHook(DeciTreeOption<AddressInfo> option) {
		return new VisiAddressDaoUpdate(option);
	}
}