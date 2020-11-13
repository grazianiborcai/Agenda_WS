package br.com.mind5.business.calendarCatalogue.model.action;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.calendarCatalogue.info.CalgueSetterAvailable;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalgueEnforceAvailable extends ActionVisitorTemplateEnforce<CalgueInfo> {
	
	public VisiCalgueEnforceAvailable(DeciTreeOption<CalgueInfo> option) {
		super(option);
	}

	
	
	@Override protected CalgueInfo enforceHook(CalgueInfo recordInfo) {
		InfoSetter<CalgueInfo> attrSetter = new CalgueSetterAvailable();
		return attrSetter.setAttr(recordInfo);
	}
}
