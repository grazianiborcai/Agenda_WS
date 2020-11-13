package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserRootInsertCus;
import br.com.mind5.security.user.model.action.StdUserEnforceUsernameDaemon;

public final class RootUserSignup extends DeciTreeTemplateWriteV2<UserInfo> {
	
	public RootUserSignup(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UserInfo> buildCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelCheckerV1<UserInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UserInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStdV2<UserInfo>> actions = new ArrayList<>();

		ActionStdV2<UserInfo> enforceDaemon = new StdUserEnforceUsernameDaemon(option);
		ActionLazy<UserInfo> insertUser = new LazyUserRootInsertCus(option.conn, option.schemaName);
				
		enforceDaemon.addPostAction(insertUser);
		
		actions.add(enforceDaemon);	
		return actions;
	}
}
