package br.com.gda.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.user.model.action.LazyUserEnforceLChanged;
import br.com.gda.security.user.model.action.LazyUserMergeUsername;
import br.com.gda.security.user.model.action.LazyUserUpdate;
import br.com.gda.security.user.model.action.StdUserMergeToUpdate;
import br.com.gda.security.user.model.checker.UserCheckDummy;

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
		ActionLazy<UserInfo> enforceLChangedBy = new LazyUserMergeUsername(option.conn, option.schemaName);		
		ActionLazy<UserInfo> updateUser = new LazyUserUpdate(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateUser);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
