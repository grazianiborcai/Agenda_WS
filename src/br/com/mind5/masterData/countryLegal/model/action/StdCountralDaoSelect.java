package br.com.mind5.masterData.countryLegal.model.action;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountralDaoSelect extends ActionStdTemplateV2<CountralInfo> {

	public StdCountralDaoSelect(DeciTreeOption<CountralInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CountralInfo> buildVisitorHook(DeciTreeOption<CountralInfo> option) {
		return new VisiCountralDaoSelect(option);
	}
}
