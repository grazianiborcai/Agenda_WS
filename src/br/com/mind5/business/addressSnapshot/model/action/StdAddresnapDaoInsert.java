package br.com.mind5.business.addressSnapshot.model.action;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddresnapDaoInsert extends ActionStdTemplate<AddresnapInfo> {

	public StdAddresnapDaoInsert(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<AddresnapInfo> buildVisitorHook(DeciTreeOption<AddresnapInfo> option) {
		return new VisiAddresnapDaoInsert(option);
	}
}
