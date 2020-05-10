package br.com.mind5.business.orderSnapshot.model.action;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdnapDaoSelect extends ActionStdTemplateV2<OrdnapInfo> {

	public StdOrdnapDaoSelect(DeciTreeOption<OrdnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OrdnapInfo> buildVisitorHook(DeciTreeOption<OrdnapInfo> option) {
		return new VisiOrdnapDaoSelect(option);
	}
}