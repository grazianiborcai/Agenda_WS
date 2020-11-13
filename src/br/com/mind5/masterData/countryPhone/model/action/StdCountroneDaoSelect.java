package br.com.mind5.masterData.countryPhone.model.action;

import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountroneDaoSelect extends ActionStdTemplate<CountroneInfo> {

	public StdCountroneDaoSelect(DeciTreeOption<CountroneInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CountroneInfo> buildVisitorHook(DeciTreeOption<CountroneInfo> option) {
		return new VisiCountroneDaoSelect(option);
	}
}
