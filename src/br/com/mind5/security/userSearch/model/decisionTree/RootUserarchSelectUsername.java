package br.com.mind5.security.userSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.action.LazyUserarchRootSelect;
import br.com.mind5.security.userSearch.model.action.StdUserarchEnforceUsername;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckReadUsername;

public final class RootUserarchSelectUsername extends DeciTreeTemplateReadV2<UserarchInfo> {
	
	public RootUserarchSelectUsername(DeciTreeOption<UserarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UserarchInfo> buildCheckerHook(DeciTreeOption<UserarchInfo> option) {
		List<ModelCheckerV1<UserarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UserarchInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UserarchCheckReadUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserarchInfo>> buildActionsOnPassedHook(DeciTreeOption<UserarchInfo> option) {
		List<ActionStdV1<UserarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UserarchInfo> enforceUsername = new StdUserarchEnforceUsername(option);
		ActionLazyV1<UserarchInfo> select = new LazyUserarchRootSelect(option.conn, option.schemaName);
		
		enforceUsername.addPostAction(select);
		
		actions.add(enforceUsername);
		return actions;
	}
}
