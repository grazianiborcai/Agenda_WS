package br.com.mind5.payment.countryPartner.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class StdCounparDaoSelect extends ActionStdTemplate<CounparInfo> {

	public StdCounparDaoSelect(DeciTreeOption<CounparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CounparInfo> buildVisitorHook(DeciTreeOption<CounparInfo> option) {
		return new VisiCounparDaoSelect(option);
	}
}
