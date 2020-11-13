package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserPersonUpdate;
import br.com.mind5.security.user.model.action.StdUserEnforcePersonKey;
import br.com.mind5.security.user.model.checker.UserCheckHasPersonData;

public final class NodeUserUpdatePerson extends DeciTreeTemplateWrite<UserInfo> {
	
	public NodeUserUpdatePerson(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildCheckerHook(DeciTreeOption<UserInfo> option) {
		final boolean HAS_PERSON = true;
		
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		ModelCheckerOption checkerOption;	
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_PERSON;		
		checker = new UserCheckHasPersonData(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> enforcePersonKey = new StdUserEnforcePersonKey(option);
		ActionLazy<UserInfo> updatePerson = new LazyUserPersonUpdate(option.conn, option.schemaName);
		
		enforcePersonKey.addPostAction(updatePerson);
		
		actions.add(enforcePersonKey);
		return actions;
	}
}
