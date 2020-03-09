package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserEnforceLChanged;
import br.com.mind5.security.user.model.action.LazyUserUpdate;
import br.com.mind5.security.user.model.action.StdUserMergeToUpdate;
import br.com.mind5.security.user.model.checker.UserCheckDummy;

public final class NodeUserUpdate extends DeciTreeWriteTemplate<UserInfo> {
	
	public NodeUserUpdate(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildDecisionCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;	
		
		checker = new UserCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> mergeToUpdate = new StdUserMergeToUpdate(option);
		ActionLazy<UserInfo> enforceLChanged = new LazyUserEnforceLChanged(option.conn, option.schemaName);				
		ActionLazy<UserInfo> updateUser = new LazyUserUpdate(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(updateUser);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
