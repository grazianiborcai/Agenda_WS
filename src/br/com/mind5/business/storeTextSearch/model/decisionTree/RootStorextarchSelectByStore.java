package br.com.mind5.business.storeTextSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.model.action.LazyStorextarchRootSelect;
import br.com.mind5.business.storeTextSearch.model.action.StdStorextarchEnforceStoreKey;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootStorextarchSelectByStore extends DeciTreeTemplateReadV2<StorextarchInfo> {
	
	public RootStorextarchSelectByStore(DeciTreeOption<StorextarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorextarchInfo> buildCheckerHook(DeciTreeOption<StorextarchInfo> option) {
		List<ModelCheckerV1<StorextarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorextarchInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);			
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorextarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextarchInfo> option) {
		List<ActionStdV1<StorextarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StorextarchInfo> enforceStoreKey = new StdStorextarchEnforceStoreKey(option);
		ActionLazyV1<StorextarchInfo> select = new LazyStorextarchRootSelect(option.conn, option.schemaName);
		
		enforceStoreKey.addPostAction(select);
		
		actions.add(enforceStoreKey);
		return actions;
	}
}
