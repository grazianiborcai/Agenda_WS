package br.com.gda.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.user.model.action.LazyUserEnforceLChangedBy;
import br.com.gda.security.user.model.action.LazyUserEnforceReference;
import br.com.gda.security.user.model.action.LazyUserInsert;
import br.com.gda.security.user.model.action.StdUserEnforceLChanged;
import br.com.gda.security.user.model.checker.UserCheckUsernameExist;

public final class NodeUserInsert extends DeciTreeWriteTemplate<UserInfo> {
	
	public NodeUserInsert(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildDecisionCheckerHook(DeciTreeOption<UserInfo> option) {
		final boolean DONT_EXIST = false;
		
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST;		
		checker = new UserCheckUsernameExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();
		
		ActionStd<UserInfo> enforceLChanged = new StdUserEnforceLChanged(option);	
		ActionLazy<UserInfo> enforceReference = new LazyUserEnforceReference(option.conn, option.schemaName);
		ActionLazy<UserInfo> insertUser = new LazyUserInsert(option.conn, option.schemaName);
		ActionLazy<UserInfo> enforceLChangedBy = new LazyUserEnforceLChangedBy(option.conn, option.schemaName);	//TODO: trocar pelo mergerUsername ?
		
		enforceLChanged.addPostAction(enforceReference);
		enforceReference.addPostAction(insertUser);
		insertUser.addPostAction(enforceLChangedBy);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
