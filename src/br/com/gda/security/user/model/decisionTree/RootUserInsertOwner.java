package br.com.gda.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.user.model.action.LazyUserEnforceAuthOwner;
import br.com.gda.security.user.model.action.LazyUserRootInsert;
import br.com.gda.security.user.model.action.StdUserEnforceCategOwner;
import br.com.gda.security.user.model.checker.UserCheckDummy;

public final class RootUserInsertOwner extends DeciTreeWriteTemplate<UserInfo> {
	
	public RootUserInsertOwner(DeciTreeOption<UserInfo> option) {
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

		ActionStd<UserInfo> enforceCateg = new StdUserEnforceCategOwner(option);
		ActionLazy<UserInfo> enforceAuthGroup = new LazyUserEnforceAuthOwner(option.conn, option.schemaName);
		ActionLazy<UserInfo> insertUser = new LazyUserRootInsert(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(enforceAuthGroup);			
		enforceAuthGroup.addPostAction(insertUser);
		
		actions.add(enforceCateg);	
		return actions;
	}
}
