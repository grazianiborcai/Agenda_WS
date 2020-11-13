package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserEnforceAuthCus;
import br.com.mind5.security.user.model.action.LazyUserRootInsert;
import br.com.mind5.security.user.model.action.StdUserEnforceCategCus;

public final class RootUserInsertCus extends DeciTreeTemplateWrite<UserInfo> {
	
	public RootUserInsertCus(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();

		ActionStd<UserInfo> enforceCateg = new StdUserEnforceCategCus(option);
		ActionLazy<UserInfo> enforceAuthGroup = new LazyUserEnforceAuthCus(option.conn, option.schemaName);
		ActionLazy<UserInfo> insertUser = new LazyUserRootInsert(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(enforceAuthGroup);			
		enforceAuthGroup.addPostAction(insertUser);
		
		actions.add(enforceCateg);	
		return actions;
	}
}
