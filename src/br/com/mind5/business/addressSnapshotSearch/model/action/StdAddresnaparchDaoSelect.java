package br.com.mind5.business.addressSnapshotSearch.model.action;

import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddresnaparchDaoSelect extends ActionStdTemplate<AddresnaparchInfo> {

	public StdAddresnaparchDaoSelect(DeciTreeOption<AddresnaparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<AddresnaparchInfo> buildVisitorHook(DeciTreeOption<AddresnaparchInfo> option) {
		return new VisiAddresnaparchDaoSelect(option);
	}
}
