package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserRootSelect;
import br.com.mind5.security.user.model.action.StdUserMergeUserarch;
import br.com.mind5.security.user.model.checker.UserCheckDummy;

public final class RootUserSearch extends DeciTreeReadTemplate<UserInfo> {
	
	public RootUserSearch(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildDecisionCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;

		checker = new UserCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> mergeUserarch = new StdUserMergeUserarch(option);
		ActionLazy<UserInfo> select = new LazyUserRootSelect(option.conn, option.schemaName);
		
		mergeUserarch.addPostAction(select);
		
		actions.add(mergeUserarch);
		return actions;
	}
}
