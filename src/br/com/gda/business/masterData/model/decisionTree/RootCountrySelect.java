package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.business.masterData.model.action.StdCountrySelect;
import br.com.gda.business.masterData.model.checker.CountryCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootCountrySelect extends DeciTreeReadTemplate<CountryInfo> {
	
	public RootCountrySelect(DeciTreeOption<CountryInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CountryInfo> buildDecisionCheckerHook(DeciTreeOption<CountryInfo> option) {
		List<ModelChecker<CountryInfo>> queue = new ArrayList<>();		
		ModelChecker<CountryInfo> checker;
		
		checker = new CountryCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CountryInfo>> buildActionsOnPassedHook(DeciTreeOption<CountryInfo> option) {
		List<ActionStd<CountryInfo>> actions = new ArrayList<>();
		
		actions.add(new StdCountrySelect(option));
		return actions;
	}
}
