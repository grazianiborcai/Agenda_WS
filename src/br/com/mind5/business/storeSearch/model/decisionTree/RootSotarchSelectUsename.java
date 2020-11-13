package br.com.mind5.business.storeSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.model.action.LazySotarchRootSelectUser;
import br.com.mind5.business.storeSearch.model.action.StdSotarchMergeUsername;
import br.com.mind5.business.storeSearch.model.checker.SotarchCheckReadUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;


public final class RootSotarchSelectUsename extends DeciTreeTemplateReadV2<SotarchInfo> {
	
	public RootSotarchSelectUsename(DeciTreeOption<SotarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SotarchInfo> buildCheckerHook(DeciTreeOption<SotarchInfo> option) {
		List<ModelCheckerV1<SotarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SotarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SotarchCheckReadUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<SotarchInfo>> buildActionsOnPassedHook(DeciTreeOption<SotarchInfo> option) {
		List<ActionStdV2<SotarchInfo>> actions = new ArrayList<>();

		ActionStdV2<SotarchInfo> mergeUsername = new StdSotarchMergeUsername(option);
		ActionLazy<SotarchInfo> select = new LazySotarchRootSelectUser(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(select);
		
		actions.add(mergeUsername);
		return actions;
	}
}
