package br.com.mind5.security.userPassword.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.action.LazyUpswdMergeUser;
import br.com.mind5.security.userPassword.model.action.LazyUpswdRootAuth;
import br.com.mind5.security.userPassword.model.action.StdUpswdEnforceUsernameKey;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckAuthUsername;
import br.com.mind5.security.userPassword.model.checker.UpswdCheckUsername;

public final class RootUpswdAuthUsername extends DeciTreeReadTemplate<UpswdInfo> {
	
	public RootUpswdAuthUsername(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UpswdInfo> buildDecisionCheckerHook(DeciTreeOption<UpswdInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<UpswdInfo>> queue = new ArrayList<>();		
		ModelChecker<UpswdInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new UpswdCheckAuthUsername();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new UpswdCheckUsername(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UpswdInfo>> buildActionsOnPassedHook(DeciTreeOption<UpswdInfo> option) {
		List<ActionStd<UpswdInfo>> actions = new ArrayList<>();
		//TODO: Criar uma VIEW para melhorar performance ?
		ActionStd<UpswdInfo> enforceUsernameKey = new StdUpswdEnforceUsernameKey(option);
		ActionLazy<UpswdInfo> mergeUser = new LazyUpswdMergeUser(option.conn, option.schemaName);
		ActionLazy<UpswdInfo> auth = new LazyUpswdRootAuth(option.conn, option.schemaName);		
		
		enforceUsernameKey.addPostAction(mergeUser);
		mergeUser.addPostAction(auth);
		
		actions.add(enforceUsernameKey);		
		return actions;
	}
}
