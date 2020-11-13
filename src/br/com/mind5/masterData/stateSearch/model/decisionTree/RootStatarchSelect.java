package br.com.mind5.masterData.stateSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.masterData.stateSearch.model.action.LazyStatarchMergeCountry;
import br.com.mind5.masterData.stateSearch.model.action.StdStatarchDaoSelect;
import br.com.mind5.masterData.stateSearch.model.checker.StatarchCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootStatarchSelect extends DeciTreeTemplateReadV2<StatarchInfo> {
	
	public RootStatarchSelect(DeciTreeOption<StatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StatarchInfo> buildCheckerHook(DeciTreeOption<StatarchInfo> option) {
		List<ModelCheckerV1<StatarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StatarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StatarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StatarchInfo> option) {
		List<ActionStdV1<StatarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StatarchInfo> select = new StdStatarchDaoSelect(option);
		ActionLazy<StatarchInfo> mergeCountry = new LazyStatarchMergeCountry(option.conn, option.schemaName);
		
		select.addPostAction(mergeCountry);
		
		actions.add(select);
		return actions;
	}
}
