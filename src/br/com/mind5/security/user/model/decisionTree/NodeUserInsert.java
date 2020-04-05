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
import br.com.mind5.security.user.model.action.LazyUserInsert;
import br.com.mind5.security.user.model.action.StdUserEnforceLChanged;
import br.com.mind5.security.user.model.checker.UserCheckDummy;

public final class NodeUserInsert extends DeciTreeWriteTemplate<UserInfo> {
	
	public NodeUserInsert(DeciTreeOption<UserInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserInfo> buildCheckerHook(DeciTreeOption<UserInfo> option) {
		List<ModelChecker<UserInfo>> queue = new ArrayList<>();		
		ModelChecker<UserInfo> checker;
	
		checker = new UserCheckDummy();
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserInfo>> buildActionsOnPassedHook(DeciTreeOption<UserInfo> option) {
		List<ActionStdV1<UserInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<UserInfo> enforceLChanged = new StdUserEnforceLChanged(option);	
		ActionLazyV1<UserInfo> insertUser = new LazyUserInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(insertUser);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
