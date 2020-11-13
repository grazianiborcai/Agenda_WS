package br.com.mind5.masterData.countrySearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.countrySearch.info.CountarchInfo;
import br.com.mind5.masterData.countrySearch.model.action.StdCountarchDaoSelect;
import br.com.mind5.masterData.countrySearch.model.checker.CountarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootCountarchSelect extends DeciTreeTemplateReadV2<CountarchInfo> {
	
	public RootCountarchSelect(DeciTreeOption<CountarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CountarchInfo> buildCheckerHook(DeciTreeOption<CountarchInfo> option) {
		List<ModelCheckerV1<CountarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CountarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CountarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CountarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CountarchInfo> option) {
		List<ActionStdV2<CountarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CountarchInfo> select = new StdCountarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
