package br.com.mind5.masterData.countryPhone.model.action;

import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountroneDaoSelect extends ActionStdTemplateV2<CountroneInfo> {

	public StdCountroneDaoSelect(DeciTreeOption<CountroneInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CountroneInfo> buildVisitorHook(DeciTreeOption<CountroneInfo> option) {
		return new VisiCountroneDaoSelect(option);
	}
}
