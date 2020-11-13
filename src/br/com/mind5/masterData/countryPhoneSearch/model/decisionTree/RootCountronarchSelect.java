package br.com.mind5.masterData.countryPhoneSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.countryPhoneSearch.info.CountronarchInfo;
import br.com.mind5.masterData.countryPhoneSearch.model.action.StdCountronarchDaoSelect;
import br.com.mind5.masterData.countryPhoneSearch.model.checker.CountronarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCountronarchSelect extends DeciTreeTemplateRead<CountronarchInfo> {
	
	public RootCountronarchSelect(DeciTreeOption<CountronarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CountronarchInfo> buildCheckerHook(DeciTreeOption<CountronarchInfo> option) {
		List<ModelChecker<CountronarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CountronarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountronarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CountronarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CountronarchInfo> option) {
		List<ActionStd<CountronarchInfo>> actions = new ArrayList<>(); 
		
		ActionStd<CountronarchInfo> select = new StdCountronarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
