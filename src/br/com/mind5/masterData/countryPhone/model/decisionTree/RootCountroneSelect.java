package br.com.mind5.masterData.countryPhone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.countryPhone.info.CountroneInfo;
import br.com.mind5.masterData.countryPhone.model.action.StdCountroneDaoSelect;
import br.com.mind5.masterData.countryPhone.model.checker.CountroneCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCountroneSelect extends DeciTreeTemplateRead<CountroneInfo> {
	
	public RootCountroneSelect(DeciTreeOption<CountroneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CountroneInfo> buildCheckerHook(DeciTreeOption<CountroneInfo> option) {
		List<ModelChecker<CountroneInfo>> queue = new ArrayList<>();		
		ModelChecker<CountroneInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountroneCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CountroneInfo>> buildActionsOnPassedHook(DeciTreeOption<CountroneInfo> option) {
		List<ActionStd<CountroneInfo>> actions = new ArrayList<>(); 
		
		ActionStd<CountroneInfo> select = new StdCountroneDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
