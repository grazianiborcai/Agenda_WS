package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.business.masterData.model.action.StdCountryPhoneSelect;
import br.com.mind5.business.masterData.model.checker.CountryPhoneCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
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
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountryPhoneCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CountryPhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<CountryPhoneInfo> option) {
		List<ActionStdV1<CountryPhoneInfo>> actions = new ArrayList<>(); 
		
		ActionStdV1<CountryPhoneInfo> select = new StdCountryPhoneSelect(option);
		
		actions.add(select);
		return actions;
	}
}
