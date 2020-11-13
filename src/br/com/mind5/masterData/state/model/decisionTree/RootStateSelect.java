package br.com.mind5.masterData.state.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.action.LazyStateMergeCountry;
import br.com.mind5.masterData.state.model.action.StdStateDaoSelect;
import br.com.mind5.masterData.state.model.checker.StateCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootStateSelect extends DeciTreeTemplateWrite<StateInfo> {
	
	public RootStateSelect(DeciTreeOption<StateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StateInfo> buildCheckerHook(DeciTreeOption<StateInfo> option) {
		List<ModelChecker<StateInfo>> queue = new ArrayList<>();		
		ModelChecker<StateInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StateCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StateInfo>> buildActionsOnPassedHook(DeciTreeOption<StateInfo> option) {
		List<ActionStd<StateInfo>> actions = new ArrayList<>();
		
		ActionStd<StateInfo> select = new StdStateDaoSelect(option);
		ActionLazy<StateInfo> mergeCountry = new LazyStateMergeCountry(option.conn, option.schemaName);
		
		select.addPostAction(mergeCountry);
		
		actions.add(select);
		return actions;
	}
}
