package br.com.mind5.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplateRootSelect;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplateMergeEmplarch;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplateCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public class RootEmplateSearch extends DeciTreeReadTemplate<EmplateInfo> {
	
	public RootEmplateSearch(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplateInfo> buildDecisionCheckerHook(DeciTreeOption<EmplateInfo> option) {
		List<ModelChecker<EmplateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplateInfo> checker;

		checker = new EmplateCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplateInfo> option) {
		List<ActionStd<EmplateInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplateInfo> mergeEmplarch = new StdEmplateMergeEmplarch(option);
		ActionLazy<EmplateInfo> select = new LazyEmplateRootSelect(option.conn, option.schemaName);
		
		mergeEmplarch.addPostAction(select);
		
		actions.add(mergeEmplarch);
		return actions;
	}
}
