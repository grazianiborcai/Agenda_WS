package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.business.masterData.model.action.LazyStateMergeCountry;
import br.com.mind5.business.masterData.model.action.StdStateSelect;
import br.com.mind5.business.masterData.model.checker.StateCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootStateSelect extends DeciTreeReadTemplate<StateInfo> {
	
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StateInfo>> buildActionsOnPassedHook(DeciTreeOption<StateInfo> option) {
		List<ActionStdV1<StateInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StateInfo> select = new StdStateSelect(option);
		ActionLazyV1<StateInfo> mergeCountry = new LazyStateMergeCountry(option.conn, option.schemaName);
		
		select.addPostAction(mergeCountry);
		
		actions.add(select);
		return actions;
	}
}
