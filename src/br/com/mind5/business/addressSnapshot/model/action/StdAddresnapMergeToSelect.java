package br.com.mind5.business.addressSnapshot.model.action;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddresnapMergeToSelect extends ActionStdTemplateV2<AddresnapInfo>{

	public StdAddresnapMergeToSelect(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<AddresnapInfo> buildVisitorHook(DeciTreeOption<AddresnapInfo> option) {
		return new VisiAddresnapMergeToSelect(option);
	}
}
