package br.com.mind5.masterData.country.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.country.model.action.StdCountryDaoSelect;
import br.com.mind5.masterData.country.model.checker.CountryCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCountrySelect extends DeciTreeTemplateRead<CountryInfo> {
	
	public RootCountrySelect(DeciTreeOption<CountryInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CountryInfo> buildCheckerHook(DeciTreeOption<CountryInfo> option) {
		List<ModelChecker<CountryInfo>> queue = new ArrayList<>();		
		ModelChecker<CountryInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountryCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CountryInfo>> buildActionsOnPassedHook(DeciTreeOption<CountryInfo> option) {
		List<ActionStd<CountryInfo>> actions = new ArrayList<>();
		
		ActionStd<CountryInfo> select = new StdCountryDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
