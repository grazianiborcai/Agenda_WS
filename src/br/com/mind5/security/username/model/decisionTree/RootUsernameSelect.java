package br.com.mind5.security.username.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.action.LazyUsernameMergeAuthGrRole;
import br.com.mind5.security.username.model.action.StdUsernameMergeToSelect;
import br.com.mind5.security.username.model.checker.UsernameCheckRead;

public final class RootUsernameSelect extends DeciTreeReadTemplate<UsernameInfo> {
	
	public RootUsernameSelect(DeciTreeOption<UsernameInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UsernameInfo> buildDecisionCheckerHook(DeciTreeOption<UsernameInfo> option) {
		List<ModelChecker<UsernameInfo>> queue = new ArrayList<>();		
		ModelChecker<UsernameInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new UsernameCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UsernameInfo>> buildActionsOnPassedHook(DeciTreeOption<UsernameInfo> option) {
		List<ActionStdV1<UsernameInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UsernameInfo> select = new StdUsernameMergeToSelect(option);
		ActionLazyV1<UsernameInfo> mergeAuthGrRole = new LazyUsernameMergeAuthGrRole(option.conn, option.schemaName);
		
		select.addPostAction(mergeAuthGrRole);
		
		actions.add(select);
		return actions;
	}
}
