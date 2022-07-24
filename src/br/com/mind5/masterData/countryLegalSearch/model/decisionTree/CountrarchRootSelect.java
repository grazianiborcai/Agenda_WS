package br.com.mind5.masterData.countryLegalSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;
import br.com.mind5.masterData.countryLegalSearch.model.action.CountrarchVisiMergeToSelect;
import br.com.mind5.masterData.countryLegalSearch.model.checker.CountrarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CountrarchRootSelect extends DeciTreeTemplateRead<CountrarchInfo> {
	
	public CountrarchRootSelect(DeciTreeOption<CountrarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CountrarchInfo> buildCheckerHook(DeciTreeOption<CountrarchInfo> option) {
		List<ModelChecker<CountrarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CountrarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountrarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CountrarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CountrarchInfo> option) {
		List<ActionStd<CountrarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CountrarchInfo> select = new ActionStdCommom<CountrarchInfo>(option, CountrarchVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
