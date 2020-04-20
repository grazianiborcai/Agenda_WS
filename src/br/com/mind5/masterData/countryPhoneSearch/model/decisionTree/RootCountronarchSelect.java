package br.com.mind5.masterData.countryPhoneSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.countryPhoneSearch.info.CountronarchInfo;
import br.com.mind5.masterData.countryPhoneSearch.model.action.StdCountronarchDaoSelect;
import br.com.mind5.masterData.countryPhoneSearch.model.checker.CountronarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCountronarchSelect extends DeciTreeTemplateReadV2<CountronarchInfo> {
	
	public RootCountronarchSelect(DeciTreeOption<CountronarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CountronarchInfo> buildCheckerHook(DeciTreeOption<CountronarchInfo> option) {
		List<ModelCheckerV1<CountronarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CountronarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountronarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CountronarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CountronarchInfo> option) {
		List<ActionStdV1<CountronarchInfo>> actions = new ArrayList<>(); 
		
		ActionStdV1<CountronarchInfo> select = new StdCountronarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}