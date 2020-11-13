package br.com.mind5.business.storeTextSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.model.action.LazyStorextarchRootSelect;
import br.com.mind5.business.storeTextSearch.model.action.StdStorextarchEnforceStoreKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootStorextarchSelectByStore extends DeciTreeTemplateRead<StorextarchInfo> {
	
	public RootStorextarchSelectByStore(DeciTreeOption<StorextarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorextarchInfo> buildCheckerHook(DeciTreeOption<StorextarchInfo> option) {
		List<ModelChecker<StorextarchInfo>> queue = new ArrayList<>();		
		ModelChecker<StorextarchInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);			
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextarchInfo> option) {
		List<ActionStd<StorextarchInfo>> actions = new ArrayList<>();
		
		ActionStd<StorextarchInfo> enforceStoreKey = new StdStorextarchEnforceStoreKey(option);
		ActionLazy<StorextarchInfo> select = new LazyStorextarchRootSelect(option.conn, option.schemaName);
		
		enforceStoreKey.addPostAction(select);
		
		actions.add(enforceStoreKey);
		return actions;
	}
}
