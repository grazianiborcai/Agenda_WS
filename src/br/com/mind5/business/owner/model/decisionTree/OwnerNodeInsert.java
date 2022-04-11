package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.OwnerVisiDaoInsert;
import br.com.mind5.business.owner.model.action.OwnerVisiEnforceCreatedBy;
import br.com.mind5.business.owner.model.action.OwnerVisiEnforceCreatedOn;
import br.com.mind5.business.owner.model.action.OwnerVisiEnforceLChanged;
import br.com.mind5.business.owner.model.action.OwnerVisiEnforceLChangedBy;
import br.com.mind5.business.owner.model.action.OwnerVisiSysonfigInsert;
import br.com.mind5.business.owner.model.action.OwnerVisiUserInsertAnonymous;
import br.com.mind5.business.owner.model.action.OwnerVisiUserInsertDaemon;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OwnerNodeInsert extends DeciTreeTemplateWrite<OwnerInfo> {
	
	public OwnerNodeInsert(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildCheckerHook(DeciTreeOption<OwnerInfo> option) {
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> enforceLChanged = new ActionStdCommom<OwnerInfo>(option, OwnerVisiEnforceLChanged.class);
		ActionLazy<OwnerInfo> enforceCreatedOn = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiEnforceCreatedOn.class);
		ActionLazy<OwnerInfo> insertOwner = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiDaoInsert.class);
		ActionLazy<OwnerInfo> insertDaemon = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiUserInsertDaemon.class);	
		ActionLazy<OwnerInfo> insertAnonymous = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiUserInsertAnonymous.class);
		ActionLazy<OwnerInfo> insertSysonfig = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiSysonfigInsert.class);		
		ActionLazy<OwnerInfo> enforceLChangedBy = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiEnforceLChangedBy.class);	
		ActionLazy<OwnerInfo> enforceCreatedBy = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiEnforceCreatedBy.class);
		
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insertOwner);
		insertOwner.addPostAction(insertDaemon);
		insertDaemon.addPostAction(insertAnonymous);
		insertAnonymous.addPostAction(insertSysonfig);
		insertSysonfig.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
