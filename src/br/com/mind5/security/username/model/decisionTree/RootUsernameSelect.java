package br.com.mind5.security.username.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.action.LazyUsernameMergeAuthGrRole;
import br.com.mind5.security.username.model.action.StdUsernameMergeToSelect;
import br.com.mind5.security.username.model.checker.UsernameCheckRead;

public final class RootUsernameSelect extends DeciTreeTemplateRead<UsernameInfo> {
	
	public RootUsernameSelect(DeciTreeOption<UsernameInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UsernameInfo> buildCheckerHook(DeciTreeOption<UsernameInfo> option) {
		List<ModelCheckerV1<UsernameInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UsernameInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new UsernameCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
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
