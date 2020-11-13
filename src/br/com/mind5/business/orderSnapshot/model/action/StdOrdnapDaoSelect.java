package br.com.mind5.business.orderSnapshot.model.action;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdnapDaoSelect extends ActionStdTemplate<OrdnapInfo> {

	public StdOrdnapDaoSelect(DeciTreeOption<OrdnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrdnapInfo> buildVisitorHook(DeciTreeOption<OrdnapInfo> option) {
		return new VisiOrdnapDaoSelect(option);
	}
}
