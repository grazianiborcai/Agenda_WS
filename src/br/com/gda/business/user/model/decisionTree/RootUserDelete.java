package br.com.gda.business.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.action.LazyUserEnforceCodUser;
import br.com.gda.business.user.model.action.LazyUserNodeDelete;
import br.com.gda.business.user.model.action.StdUserMergeUsername;
import br.com.gda.business.user.model.checker.UserCheckDelete;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootUserDelete extends DeciTreeWriteTemplate<UserInfo> {
	
	public RootUserDelete(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildDecisionCheckerHook(DeciTreeOption<UserInfo> option) {
		
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		
		checker = new UserCheckDelete();
		queue.add(checker);

		return new ModelCheckerQueue<UserInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> enforceLChangedBy = new StdUserMergeUsername(option);		
		ActionLazy<UserInfo> enforceCodUser = new LazyUserEnforceCodUser(option.conn, option.schemaName);
		ActionLazy<UserInfo> nodeDelete = new LazyUserNodeDelete(option.conn, option.schemaName);			
		
		enforceLChangedBy.addPostAction(enforceCodUser);
		enforceCodUser.addPostAction(nodeDelete);
 
		actions.add(enforceLChangedBy);
		
		return actions;
	}
}
