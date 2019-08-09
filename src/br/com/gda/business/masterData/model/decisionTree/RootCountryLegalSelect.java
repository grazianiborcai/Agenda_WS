package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.CountryLegalInfo;
import br.com.gda.business.masterData.model.action.LazyCountryLegalMergeCountry;
import br.com.gda.business.masterData.model.action.StdCountryLegalSelect;
import br.com.gda.business.masterData.model.checker.CountryLegalCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootCountryLegalSelect extends DeciTreeReadTemplate<CountryLegalInfo> {
	
	public RootCountryLegalSelect(DeciTreeOption<CountryLegalInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CountryLegalInfo> buildDecisionCheckerHook(DeciTreeOption<CountryLegalInfo> option) {
		List<ModelChecker<CountryLegalInfo>> queue = new ArrayList<>();		
		ModelChecker<CountryLegalInfo> checker;
		
		checker = new CountryLegalCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CountryLegalInfo>> buildActionsOnPassedHook(DeciTreeOption<CountryLegalInfo> option) {
		List<ActionStd<CountryLegalInfo>> actions = new ArrayList<>();
		
		ActionStd<CountryLegalInfo> select = new StdCountryLegalSelect(option);
		ActionLazy<CountryLegalInfo> mergeCountry = new LazyCountryLegalMergeCountry(option.conn, option.schemaName);
		
		select.addPostAction(mergeCountry);
		
		actions.add(select);
		return actions;
	}
}
