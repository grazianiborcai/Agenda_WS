package br.com.mind5.security.userList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.action.LazyUselisRootSelect;
import br.com.mind5.security.userList.model.action.StdUselisMergeUserarch;
import br.com.mind5.security.userList.model.checker.UselisCheckDummy;

public final class RootUselisSearch extends DeciTreeTemplateRead<UselisInfo> {
	
	public RootUselisSearch(DeciTreeOption<UselisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<UselisInfo> buildCheckerHook(DeciTreeOption<UselisInfo> option) {
		List<ModelCheckerV1<UselisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<UselisInfo> checker;	
		
		checker = new UselisCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UselisInfo>> buildActionsOnPassedHook(DeciTreeOption<UselisInfo> option) {
		List<ActionStdV1<UselisInfo>> actions = new ArrayList<>();
		
		ActionStdV1<UselisInfo> mergeUserarch = new StdUselisMergeUserarch(option);
		ActionLazyV1<UselisInfo> select = new LazyUselisRootSelect(option.conn, option.schemaName);
		
		mergeUserarch.addPostAction(select);
		
		actions.add(mergeUserarch);
		return actions;
	}
}
