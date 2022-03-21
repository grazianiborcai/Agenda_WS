package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StoreVisiDaoInsert;
import br.com.mind5.business.store.model.action.StoreVisiEnforceCreatedBy;
import br.com.mind5.business.store.model.action.StoreVisiEnforceCreatedOn;
import br.com.mind5.business.store.model.action.StoreVisiEnforceLChanged;
import br.com.mind5.business.store.model.action.StoreVisiEnforceLockedOff;
import br.com.mind5.business.store.model.action.StoreVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StoreNodeInsert extends DeciTreeTemplateWrite<StoreInfo> {
	
	public StoreNodeInsert(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();

		ActionStd<StoreInfo> enforceLChanged = new ActionStdCommom<StoreInfo>(option, StoreVisiEnforceLChanged.class);
		ActionLazy<StoreInfo> enforceLChangedBy = new  ActionLazyCommom<StoreInfo>(option, StoreVisiMergeUsername.class);
		ActionLazy<StoreInfo> enforceCreatedBy = new  ActionLazyCommom<StoreInfo>(option, StoreVisiEnforceCreatedBy.class);
		ActionLazy<StoreInfo> enforceCreatedOn = new  ActionLazyCommom<StoreInfo>(option, StoreVisiEnforceCreatedOn.class);
		ActionLazy<StoreInfo> enforceLockedOff = new  ActionLazyCommom<StoreInfo>(option, StoreVisiEnforceLockedOff.class);
		ActionLazy<StoreInfo> insertStore = new  ActionLazyCommom<StoreInfo>(option, StoreVisiDaoInsert.class);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceLockedOff);
		enforceLockedOff.addPostAction(insertStore);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
