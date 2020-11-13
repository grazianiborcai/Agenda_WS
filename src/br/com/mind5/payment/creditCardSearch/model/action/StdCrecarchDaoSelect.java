package br.com.mind5.payment.creditCardSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

public final class StdCrecarchDaoSelect extends ActionStdTemplateV2<CrecarchInfo> {

	public StdCrecarchDaoSelect(DeciTreeOption<CrecarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CrecarchInfo> buildVisitorHook(DeciTreeOption<CrecarchInfo> option) {
		return new VisiCrecarchDaoSelect(option);
	}
}
