package br.com.mind5.security.userList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.action.LazyUselisRootSelect;
import br.com.mind5.security.userList.model.action.StdUselisMergeUserarch;

public final class RootUselisSearch extends DeciTreeTemplateRead<UselisInfo> {
	
	public RootUselisSearch(DeciTreeOption<UselisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UselisInfo> buildCheckerHook(DeciTreeOption<UselisInfo> option) {
		List<ModelChecker<UselisInfo>> queue = new ArrayList<>();		
		ModelChecker<UselisInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UselisInfo>> buildActionsOnPassedHook(DeciTreeOption<UselisInfo> option) {
		List<ActionStd<UselisInfo>> actions = new ArrayList<>();
		
		ActionStd<UselisInfo> mergeUserarch = new StdUselisMergeUserarch(option);
		ActionLazy<UselisInfo> select = new LazyUselisRootSelect(option.conn, option.schemaName);
		
		mergeUserarch.addPostAction(select);
		
		actions.add(mergeUserarch);
		return actions;
	}
}
