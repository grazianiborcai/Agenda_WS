package br.com.mind5.security.username.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.action.LazyUsernameMergeAuthgrole;
import br.com.mind5.security.username.model.action.StdUsernameMergeToSelect;
import br.com.mind5.security.username.model.checker.UsernameCheckRead;

public final class RootUsernameSelect extends DeciTreeTemplateRead<UsernameInfo> {
	
	public RootUsernameSelect(DeciTreeOption<UsernameInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UsernameInfo> buildCheckerHook(DeciTreeOption<UsernameInfo> option) {
		List<ModelChecker<UsernameInfo>> queue = new ArrayList<>();		
		ModelChecker<UsernameInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new UsernameCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UsernameInfo>> buildActionsOnPassedHook(DeciTreeOption<UsernameInfo> option) {
		List<ActionStd<UsernameInfo>> actions = new ArrayList<>();
		
		ActionStd<UsernameInfo> select = new StdUsernameMergeToSelect(option);
		ActionLazy<UsernameInfo> mergeAuthgrole = new LazyUsernameMergeAuthgrole(option.conn, option.schemaName);
		
		select.addPostAction(mergeAuthgrole);
		
		actions.add(select);
		return actions;
	}
}
