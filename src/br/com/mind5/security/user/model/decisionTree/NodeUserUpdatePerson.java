package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserPersonUpdate;
import br.com.mind5.security.user.model.action.StdUserEnforcePersonKey;
import br.com.mind5.security.user.model.checker.UserCheckHasPersonData;

public final class NodeUserUpdatePerson extends DeciTreeTemplateWriteV2<UserInfo> {
	
	public NodeUserUpdatePerson(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UserInfo> buildCheckerHook(DeciTreeOption<UserInfo> option) {
		final boolean HAS_PERSON = true;
		
		List<ModelCheckerV1<UserInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UserInfo> checker;
		ModelCheckerOption checkerOption;	
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_PERSON;		
		checker = new UserCheckHasPersonData(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStdV1<UserInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UserInfo> enforcePersonKey = new StdUserEnforcePersonKey(option);
		ActionLazyV1<UserInfo> updatePerson = new LazyUserPersonUpdate(option.conn, option.schemaName);
		
		enforcePersonKey.addPostAction(updatePerson);
		
		actions.add(enforcePersonKey);
		return actions;
	}
}
