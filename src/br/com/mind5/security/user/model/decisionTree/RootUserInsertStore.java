package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserEnforceAuthStore;
import br.com.mind5.security.user.model.action.LazyUserRootInsert;
import br.com.mind5.security.user.model.action.StdUserEnforceCategStore;
import br.com.mind5.security.user.model.checker.UserCheckDummy;

public final class RootUserInsertStore extends DeciTreeWriteTemplate<UserInfo> {
	
	public RootUserInsertStore(DeciTreeOption<UserInfo> option) {
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

		ActionStd<UserInfo> enforceCateg = new StdUserEnforceCategStore(option);
		ActionLazy<UserInfo> enforceAuthGroup = new LazyUserEnforceAuthStore(option.conn, option.schemaName);
		ActionLazy<UserInfo> insertUser = new LazyUserRootInsert(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(enforceAuthGroup);			
		enforceAuthGroup.addPostAction(insertUser);
		
		actions.add(enforceCateg);	
		return actions;
	}
}
