package br.com.mind5.business.storeTextSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.business.storeTextSearch.model.action.StorextarchVisiRootSelect;
import br.com.mind5.business.storeTextSearch.model.action.StorextarchVisiEnforceStoreKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StorextarchRootSelectStore extends DeciTreeTemplateRead<StorextarchInfo> {
	
	public StorextarchRootSelectStore(DeciTreeOption<StorextarchInfo> option) {
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
		
		ActionStd<StorextarchInfo> enforceStoreKey = new ActionStdCommom<StorextarchInfo>(option, StorextarchVisiEnforceStoreKey.class);
		ActionLazy<StorextarchInfo> select = new ActionLazyCommom<StorextarchInfo>(option, StorextarchVisiRootSelect.class);
		
		enforceStoreKey.addPostAction(select);
		
		actions.add(enforceStoreKey);
		return actions;
	}
}
