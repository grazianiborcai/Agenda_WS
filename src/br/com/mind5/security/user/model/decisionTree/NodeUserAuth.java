package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserEnforceCodUser;
import br.com.mind5.security.user.model.action.StdUserMergeUsername;
import br.com.mind5.security.user.model.checker.UserCheckUserarch;

public final class NodeUserAuth extends DeciTreeReadTemplate<UserInfo> {
	
	public NodeUserAuth(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildDecisionCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new UserCheckUserarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> mergeUsername = new StdUserMergeUsername(option);
		ActionLazy<UserInfo> enforceCodUser = new LazyUserEnforceCodUser(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(enforceCodUser);
		
		actions.add(mergeUsername);
		return actions;
	}
}
