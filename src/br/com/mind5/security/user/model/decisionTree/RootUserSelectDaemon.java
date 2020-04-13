package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserEnforceCategDaemon;
import br.com.mind5.security.user.model.action.LazyUserMergeUserarch;
import br.com.mind5.security.user.model.action.LazyUserRootSelect;
import br.com.mind5.security.user.model.action.StdUserEnforceUsernameDaemon;
import br.com.mind5.security.user.model.checker.UserCheckReadDaemon;

public final class RootUserSelectDaemon extends DeciTreeTemplateReadV1<UserInfo> {
	
	public RootUserSelectDaemon(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UserInfo> buildCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelCheckerV1<UserInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UserInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UserCheckReadDaemon(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStdV1<UserInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UserInfo> enforceUsername = new StdUserEnforceUsernameDaemon(option);
		ActionLazyV1<UserInfo> enforceCateg = new LazyUserEnforceCategDaemon(option.conn, option.schemaName);		
		ActionLazyV1<UserInfo> mergeUserarch = new LazyUserMergeUserarch(option.conn, option.schemaName);
		ActionLazyV1<UserInfo> select = new LazyUserRootSelect(option.conn, option.schemaName);
		
		enforceUsername.addPostAction(enforceCateg);
		enforceCateg.addPostAction(mergeUserarch);
		mergeUserarch.addPostAction(select);
		
		actions.add(enforceUsername);
		return actions;
	}
}
