package br.com.mind5.business.storeFavorite.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.action.LazyStoriteRootSelect;
import br.com.mind5.business.storeFavorite.model.action.StdStoriteMergeStoritarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootStoriteSearch extends DeciTreeTemplateWriteV2<StoriteInfo> {
	
	public RootStoriteSearch(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoriteInfo> buildCheckerHook(DeciTreeOption<StoriteInfo> option) {
		List<ModelCheckerV1<StoriteInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoriteInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoriteInfo>> buildActionsOnPassedHook(DeciTreeOption<StoriteInfo> option) {
		List<ActionStdV1<StoriteInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoriteInfo> mergeStoritarch = new StdStoriteMergeStoritarch(option);
		ActionLazy<StoriteInfo> select = new LazyStoriteRootSelect(option.conn, option.schemaName);
		
		mergeStoritarch.addPostAction(select);
		
		actions.add(mergeStoritarch);	
		return actions;
	}
}
