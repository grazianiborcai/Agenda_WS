package br.com.mind5.payment.countryPartnerSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

public final class StdCounparchDaoSelect extends ActionStdTemplate<CounparchInfo> {

	public StdCounparchDaoSelect(DeciTreeOption<CounparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CounparchInfo> buildVisitorHook(DeciTreeOption<CounparchInfo> option) {
		return new VisiCounparchDaoSelect(option);
	}
}
