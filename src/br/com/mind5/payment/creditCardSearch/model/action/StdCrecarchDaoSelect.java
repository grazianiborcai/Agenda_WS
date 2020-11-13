package br.com.mind5.payment.creditCardSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

public final class StdCrecarchDaoSelect extends ActionStdTemplate<CrecarchInfo> {

	public StdCrecarchDaoSelect(DeciTreeOption<CrecarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CrecarchInfo> buildVisitorHook(DeciTreeOption<CrecarchInfo> option) {
		return new VisiCrecarchDaoSelect(option);
	}
}
