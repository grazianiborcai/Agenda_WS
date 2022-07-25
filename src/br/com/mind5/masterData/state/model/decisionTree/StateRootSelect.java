package br.com.mind5.masterData.state.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.action.StateVisiDaoSelect;
import br.com.mind5.masterData.state.model.action.StateVisiMergeCountry;
import br.com.mind5.masterData.state.model.checker.StateCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StateRootSelect extends DeciTreeTemplateWrite<StateInfo> {
	
	public StateRootSelect(DeciTreeOption<StateInfo> option) {
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
		
		ActionStd<StateInfo> select = new ActionStdCommom<StateInfo>(option, StateVisiDaoSelect.class);
		ActionLazy<StateInfo> mergeCountry = new ActionLazyCommom<StateInfo>(option, StateVisiMergeCountry.class);
		
		select.addPostAction(mergeCountry);
		
		actions.add(select);
		return actions;
	}
}
