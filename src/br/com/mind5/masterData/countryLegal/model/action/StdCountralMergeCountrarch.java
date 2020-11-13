package br.com.mind5.masterData.countryLegal.model.action;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountralMergeCountrarch extends ActionStdTemplate<CountralInfo> {

	public StdCountralMergeCountrarch(DeciTreeOption<CountralInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CountralInfo> buildVisitorHook(DeciTreeOption<CountralInfo> option) {
		return new VisiCountralMergeCountrarch(option);
	}
}
