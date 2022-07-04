package br.com.mind5.business.materialStoreSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSearch.model.action.MatorarchVisiEnforceStoreKey;
import br.com.mind5.business.materialStoreSearch.model.action.MatorarchVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatorarchRootSelectStore extends DeciTreeTemplateRead<MatorarchInfo> {
	
	public MatorarchRootSelectStore(DeciTreeOption<MatorarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatorarchInfo> buildCheckerHook(DeciTreeOption<MatorarchInfo> option) {
		List<ModelChecker<MatorarchInfo>> queue = new ArrayList<>();		
		ModelChecker<MatorarchInfo> checker;
			
		checker = new ModelCheckerDummy<MatorarchInfo>();
		queue.add(checker);		
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatorarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatorarchInfo> option) {
		List<ActionStd<MatorarchInfo>> actions = new ArrayList<>();
		
		ActionStd<MatorarchInfo> enforceStoreKey = new ActionStdCommom<MatorarchInfo>(option, MatorarchVisiEnforceStoreKey.class);
		ActionLazy<MatorarchInfo> select = new ActionLazyCommom<MatorarchInfo>(option, MatorarchVisiRootSelect.class);
		
		enforceStoreKey.addPostAction(select);
		
		
		actions.add(enforceStoreKey);
		
		return actions;
	}
}
