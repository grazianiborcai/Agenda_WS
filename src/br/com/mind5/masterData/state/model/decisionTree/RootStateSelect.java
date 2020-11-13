package br.com.mind5.masterData.state.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.action.LazyStateMergeCountry;
import br.com.mind5.masterData.state.model.action.StdStateDaoSelect;
import br.com.mind5.masterData.state.model.checker.StateCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootStateSelect extends DeciTreeTemplateWriteV2<StateInfo> {
	
	public RootStateSelect(DeciTreeOption<StateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StateInfo> buildCheckerHook(DeciTreeOption<StateInfo> option) {
		List<ModelCheckerV1<StateInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StateInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StateCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StateInfo>> buildActionsOnPassedHook(DeciTreeOption<StateInfo> option) {
		List<ActionStdV1<StateInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StateInfo> select = new StdStateDaoSelect(option);
		ActionLazy<StateInfo> mergeCountry = new LazyStateMergeCountry(option.conn, option.schemaName);
		
		select.addPostAction(mergeCountry);
		
		actions.add(select);
		return actions;
	}
}
