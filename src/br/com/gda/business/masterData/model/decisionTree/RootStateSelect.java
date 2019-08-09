package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.StateInfo;
import br.com.gda.business.masterData.model.action.LazyStateMergeCountry;
import br.com.gda.business.masterData.model.action.StdStateSelect;
import br.com.gda.business.masterData.model.checker.StateCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootStateSelect extends DeciTreeReadTemplate<StateInfo> {
	
	public RootStateSelect(DeciTreeOption<StateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StateInfo> buildDecisionCheckerHook(DeciTreeOption<StateInfo> option) {
		List<ModelChecker<StateInfo>> queue = new ArrayList<>();		
		ModelChecker<StateInfo> checker;
		
		checker = new StateCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StateInfo>> buildActionsOnPassedHook(DeciTreeOption<StateInfo> option) {
		List<ActionStd<StateInfo>> actions = new ArrayList<>();
		
		ActionStd<StateInfo> select = new StdStateSelect(option);
		ActionLazy<StateInfo> mergeCountry = new LazyStateMergeCountry(option.conn, option.schemaName);
		
		select.addPostAction(mergeCountry);
		
		actions.add(select);
		return actions;
	}
}
