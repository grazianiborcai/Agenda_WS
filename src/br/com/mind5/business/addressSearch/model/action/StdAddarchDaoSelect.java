package br.com.mind5.business.addressSearch.model.action;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddarchDaoSelect extends ActionStdTemplate<AddarchInfo> {

	public StdAddarchDaoSelect(DeciTreeOption<AddarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<AddarchInfo> buildVisitorHook(DeciTreeOption<AddarchInfo> option) {
		return new VisiAddarchDaoSelect(option);
	}
}
