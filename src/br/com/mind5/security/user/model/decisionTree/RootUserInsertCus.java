package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserEnforceAuthCus;
import br.com.mind5.security.user.model.action.LazyUserRootInsert;
import br.com.mind5.security.user.model.action.StdUserEnforceCategCus;

public final class RootUserInsertCus extends DeciTreeTemplateWriteV2<UserInfo> {
	
	public RootUserInsertCus(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UserInfo> buildCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelCheckerV1<UserInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UserInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStdV1<UserInfo>> actions = new ArrayList<>();

		ActionStdV1<UserInfo> enforceCateg = new StdUserEnforceCategCus(option);
		ActionLazy<UserInfo> enforceAuthGroup = new LazyUserEnforceAuthCus(option.conn, option.schemaName);
		ActionLazy<UserInfo> insertUser = new LazyUserRootInsert(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(enforceAuthGroup);			
		enforceAuthGroup.addPostAction(insertUser);
		
		actions.add(enforceCateg);	
		return actions;
	}
}
