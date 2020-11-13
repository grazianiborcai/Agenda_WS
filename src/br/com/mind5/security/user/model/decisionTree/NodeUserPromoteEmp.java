package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserEnforceAuthEmp;
import br.com.mind5.security.user.model.action.LazyUserNodeSnapshot;
import br.com.mind5.security.user.model.action.LazyUserNodeUpdate;
import br.com.mind5.security.user.model.action.LazyUserRootSelect;
import br.com.mind5.security.user.model.action.StdUserEnforceCategEmp;
import br.com.mind5.security.user.model.action.StdUserSuccess;
import br.com.mind5.security.user.model.checker.UserCheckAuthCustomer;

public final class NodeUserPromoteEmp extends DeciTreeTemplateWriteV2<UserInfo> {
	
	public NodeUserPromoteEmp(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UserInfo> buildCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelCheckerV1<UserInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UserInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new UserCheckAuthCustomer(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStdV1<UserInfo>> actions = new ArrayList<>();

		ActionStdV1<UserInfo> enforceCateg = new StdUserEnforceCategEmp(option);
		ActionLazy<UserInfo> enforceAuthGroup = new LazyUserEnforceAuthEmp(option.conn, option.schemaName);
		ActionLazy<UserInfo> update = new LazyUserNodeUpdate(option.conn, option.schemaName);
		ActionLazy<UserInfo> snapshot = new LazyUserNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<UserInfo> select = new LazyUserRootSelect(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(enforceAuthGroup);			
		enforceAuthGroup.addPostAction(update);
		update.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceCateg);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<UserInfo>> buildActionsOnFailedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStdV1<UserInfo>> actions = new ArrayList<>();

		ActionStdV1<UserInfo> success = new StdUserSuccess(option);
		
		actions.add(success);	
		return actions;
	}
}
