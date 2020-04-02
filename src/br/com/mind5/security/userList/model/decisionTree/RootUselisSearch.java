package br.com.mind5.security.userList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.action.LazyUselisRootSelect;
import br.com.mind5.security.userList.model.action.StdUselisMergeUserarch;
import br.com.mind5.security.userList.model.checker.UselisCheckDummy;

public final class RootUselisSearch extends DeciTreeReadTemplate<UselisInfo> {
	
	public RootUselisSearch(DeciTreeOption<UselisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UselisInfo> buildDecisionCheckerHook(DeciTreeOption<UselisInfo> option) {
		List<ModelChecker<UselisInfo>> queue = new ArrayList<>();		
		ModelChecker<UselisInfo> checker;	
		
		checker = new UselisCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UselisInfo>> buildActionsOnPassedHook(DeciTreeOption<UselisInfo> option) {
		List<ActionStdV1<UselisInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UselisInfo> mergeUserarch = new StdUselisMergeUserarch(option);
		ActionLazyV1<UselisInfo> select = new LazyUselisRootSelect(option.conn, option.schemaName);
		
		mergeUserarch.addPostAction(select);
		
		actions.add(mergeUserarch);
		return actions;
	}
}
