package br.com.mind5.security.user.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.action.LazyUserEnforceLChangedBy;
import br.com.mind5.security.user.model.action.LazyUserInsert;
import br.com.mind5.security.user.model.action.StdUserEnforceLChanged;
import br.com.mind5.security.user.model.checker.UserCheckUsername;

public final class NodeUserInsert extends DeciTreeWriteTemplate<UserInfo> {
	
	public NodeUserInsert(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildDecisionCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new UserCheckUsername(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStd<UserInfo>> actions = new ArrayList<>();		
		
		ActionStd<UserInfo> enforceLChanged = new StdUserEnforceLChanged(option);	
		ActionLazy<UserInfo> insertUser = new LazyUserInsert(option.conn, option.schemaName);
		ActionLazy<UserInfo> enforceLChangedBy = new LazyUserEnforceLChangedBy(option.conn, option.schemaName);	//TODO: trocar pelo mergerUsername ?
		
		enforceLChanged.addPostAction(insertUser);
		insertUser.addPostAction(enforceLChangedBy);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
