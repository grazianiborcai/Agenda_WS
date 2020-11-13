package br.com.mind5.business.storeFavorite.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.action.LazyStoriteRootSearch;
import br.com.mind5.business.storeFavorite.model.action.StdStoriteMergeUsername;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckSearchAuth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootStoriteSearchAuth extends DeciTreeTemplateWriteV2<StoriteInfo> {
	
	public RootStoriteSearchAuth(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoriteInfo> buildCheckerHook(DeciTreeOption<StoriteInfo> option) {
		List<ModelCheckerV1<StoriteInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoriteInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoriteCheckSearchAuth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoriteInfo>> buildActionsOnPassedHook(DeciTreeOption<StoriteInfo> option) {
		List<ActionStdV1<StoriteInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoriteInfo> mergeUsername = new StdStoriteMergeUsername(option);
		ActionLazy<StoriteInfo> search = new LazyStoriteRootSearch(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(search);
		
		actions.add(mergeUsername);	
		return actions;
	}
}
