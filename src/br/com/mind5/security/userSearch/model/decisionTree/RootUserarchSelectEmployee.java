package br.com.mind5.security.userSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.action.LazyUserarchRootSelectAuth;
import br.com.mind5.security.userSearch.model.action.StdUserarchEnforceEmployee;

public final class RootUserarchSelectEmployee extends DeciTreeTemplateRead<UserarchInfo> {
	
	public RootUserarchSelectEmployee(DeciTreeOption<UserarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserarchInfo> buildCheckerHook(DeciTreeOption<UserarchInfo> option) {
		List<ModelChecker<UserarchInfo>> queue = new ArrayList<>();		
		ModelChecker<UserarchInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserarchInfo>> buildActionsOnPassedHook(DeciTreeOption<UserarchInfo> option) {
		List<ActionStd<UserarchInfo>> actions = new ArrayList<>();
		
		ActionStd<UserarchInfo> enforceEmployee = new StdUserarchEnforceEmployee(option);
		ActionLazy<UserarchInfo> select = new LazyUserarchRootSelectAuth(option.conn, option.schemaName);
		
		enforceEmployee.addPostAction(select);
		
		actions.add(enforceEmployee);
		return actions;
	}
}
