package br.com.mind5.payment.countryPartnerSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

public final class StdCounparchDaoSelect extends ActionStdTemplateV2<CounparchInfo> {

	public StdCounparchDaoSelect(DeciTreeOption<CounparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CounparchInfo> buildVisitorHook(DeciTreeOption<CounparchInfo> option) {
		return new VisiCounparchDaoSelect(option);
	}
}
