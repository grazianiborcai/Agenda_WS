package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.business.masterData.model.action.StdCountryPhoneSelect;
import br.com.mind5.business.masterData.model.checker.CountryPhoneCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootCountryPhoneSelect extends DeciTreeReadTemplate<CountryPhoneInfo> {
	
	public RootCountryPhoneSelect(DeciTreeOption<CountryPhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CountryPhoneInfo> buildDecisionCheckerHook(DeciTreeOption<CountryPhoneInfo> option) {
		List<ModelChecker<CountryPhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<CountryPhoneInfo> checker;
		
		checker = new CountryPhoneCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CountryPhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<CountryPhoneInfo> option) {
		List<ActionStd<CountryPhoneInfo>> actions = new ArrayList<>();
		
		actions.add(new StdCountryPhoneSelect(option));
		return actions;
	}
}
