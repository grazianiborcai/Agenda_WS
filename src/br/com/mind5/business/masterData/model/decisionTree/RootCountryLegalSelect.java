package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.business.masterData.model.action.LazyCountryLegalMergeCountry;
import br.com.mind5.business.masterData.model.action.StdCountryLegalSelect;
import br.com.mind5.business.masterData.model.checker.CountryLegalCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootCountryLegalSelect extends DeciTreeReadTemplate<CountryLegalInfo> {
	
	public RootCountryLegalSelect(DeciTreeOption<CountryLegalInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CountryLegalInfo> buildDecisionCheckerHook(DeciTreeOption<CountryLegalInfo> option) {
		List<ModelChecker<CountryLegalInfo>> queue = new ArrayList<>();		
		ModelChecker<CountryLegalInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountryLegalCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CountryLegalInfo>> buildActionsOnPassedHook(DeciTreeOption<CountryLegalInfo> option) {
		List<ActionStdV1<CountryLegalInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CountryLegalInfo> select = new StdCountryLegalSelect(option);
		ActionLazyV1<CountryLegalInfo> mergeCountry = new LazyCountryLegalMergeCountry(option.conn, option.schemaName);
		
		select.addPostAction(mergeCountry);
		
		actions.add(select);
		return actions;
	}
}
