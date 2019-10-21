package br.com.mind5.security.username.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.action.LazyUsernameMergeAuthGrRole;
import br.com.mind5.security.username.model.action.StdUsernameSelect;
import br.com.mind5.security.username.model.checker.UsernameCheckRead;

public final class RootUsernameSelect extends DeciTreeReadTemplate<UsernameInfo> {
	
	public RootUsernameSelect(DeciTreeOption<UsernameInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UsernameInfo> buildDecisionCheckerHook(DeciTreeOption<UsernameInfo> option) {
		List<ModelChecker<UsernameInfo>> queue = new ArrayList<>();		
		ModelChecker<UsernameInfo> checker;
		
		checker = new UsernameCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UsernameInfo>> buildActionsOnPassedHook(DeciTreeOption<UsernameInfo> option) {
		List<ActionStd<UsernameInfo>> actions = new ArrayList<>();
		
		ActionStd<UsernameInfo> select = new StdUsernameSelect(option);
		ActionLazy<UsernameInfo> mergeAuthGrRole = new LazyUsernameMergeAuthGrRole(option.conn, option.schemaName);
		
		select.addPostAction(mergeAuthGrRole);
		
		actions.add(select);
		return actions;
	}
}
