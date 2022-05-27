package br.com.mind5.business.storeProspectSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.business.storeProspectSearch.model.action.StoprarchVisiEnforceCreatedKey;
import br.com.mind5.business.storeProspectSearch.model.action.StoprarchVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class StoprarchRootSelectCreated extends DeciTreeTemplateRead<StoprarchInfo> {
	
	public StoprarchRootSelectCreated(DeciTreeOption<StoprarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoprarchInfo> buildCheckerHook(DeciTreeOption<StoprarchInfo> option) {
		List<ModelChecker<StoprarchInfo>> queue = new ArrayList<>();		
		ModelChecker<StoprarchInfo> checker;
			
		checker = new ModelCheckerDummy<StoprarchInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoprarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StoprarchInfo> option) {
		List<ActionStd<StoprarchInfo>> actions = new ArrayList<>();

		ActionStd<StoprarchInfo> enforceCreatedKey = new ActionStdCommom<StoprarchInfo>(option, StoprarchVisiEnforceCreatedKey.class);
		ActionLazy<StoprarchInfo> select = new ActionLazyCommom<StoprarchInfo>(option, StoprarchVisiRootSelect.class);
		
		enforceCreatedKey.addPostAction(select);
		
		actions.add(enforceCreatedKey);
		return actions;
	}
}
