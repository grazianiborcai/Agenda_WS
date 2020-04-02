package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserUpdate;
import br.com.mind5.security.user.model.action.StdUserInsertUserap;
import br.com.mind5.security.user.model.checker.UserCheckDummy;

public final class NodeUserSnapshot extends DeciTreeWriteTemplate<UserInfo> {
	
	public NodeUserSnapshot(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildDecisionCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;	
		
		checker = new UserCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStdV1<UserInfo>> actions = new ArrayList<>();

		ActionStdV1<UserInfo> insertSnapshot = new StdUserInsertUserap(option);		
		ActionLazyV1<UserInfo> updateUser = new LazyUserUpdate(option.conn, option.schemaName);
		
		insertSnapshot.addPostAction(updateUser);
		
		actions.add(insertSnapshot);	
		return actions;
	}
}
