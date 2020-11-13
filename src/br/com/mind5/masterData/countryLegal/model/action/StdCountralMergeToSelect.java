package br.com.mind5.masterData.countryLegal.model.action;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountralMergeToSelect extends ActionStdTemplate<CountralInfo> {
	
	public StdCountralMergeToSelect(DeciTreeOption<CountralInfo> option) {			
		super(option);
	}
	
	
	
	protected ActionVisitor<CountralInfo> buildVisitorHook(DeciTreeOption<CountralInfo> option) {
		return new VisiCountralMergeToSelect(option);
	}
}
