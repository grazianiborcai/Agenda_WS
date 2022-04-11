package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.OwnerVisiCompInsert;
import br.com.mind5.business.owner.model.action.OwnerVisiDaoUpdate;
import br.com.mind5.business.owner.model.action.OwnerVisiEnforceCompKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OwnerNodeCompInsert extends DeciTreeTemplateWrite<OwnerInfo> {
	
	public OwnerNodeCompInsert(DeciTreeOption<OwnerInfo> option) {
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
		
		ActionStd<OwnerInfo> enforceCompKey = new ActionStdCommom<OwnerInfo>(option, OwnerVisiEnforceCompKey.class);
		ActionLazy<OwnerInfo> insertComp = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiCompInsert.class);
		ActionLazy<OwnerInfo> updateOwner = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiDaoUpdate.class);
		
		enforceCompKey.addPostAction(insertComp);
		insertComp.addPostAction(updateOwner);
		
		actions.add(enforceCompKey);	
		return actions;
	}
}
