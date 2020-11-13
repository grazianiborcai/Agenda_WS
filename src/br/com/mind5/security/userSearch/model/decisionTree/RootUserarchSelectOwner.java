package br.com.mind5.security.userSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.action.LazyUserarchRootSelectAuth;
import br.com.mind5.security.userSearch.model.action.StdUserarchEnforceOwner;

public final class RootUserarchSelectOwner extends DeciTreeTemplateReadV2<UserarchInfo> {
	
	public RootUserarchSelectOwner(DeciTreeOption<UserarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UserarchInfo> buildCheckerHook(DeciTreeOption<UserarchInfo> option) {
		List<ModelCheckerV1<UserarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UserarchInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<UserarchInfo>> buildActionsOnPassedHook(DeciTreeOption<UserarchInfo> option) {
		List<ActionStdV2<UserarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<UserarchInfo> enforceOwner = new StdUserarchEnforceOwner(option);
		ActionLazy<UserarchInfo> select = new LazyUserarchRootSelectAuth(option.conn, option.schemaName);
		
		enforceOwner.addPostAction(select);
		
		actions.add(enforceOwner);
		return actions;
	}
}
