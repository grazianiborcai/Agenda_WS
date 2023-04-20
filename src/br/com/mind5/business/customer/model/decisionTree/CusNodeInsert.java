package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.CusVisiDaoInsert;
import br.com.mind5.business.customer.model.action.CusVisiEnforceCreatedBy;
import br.com.mind5.business.customer.model.action.CusVisiEnforceCreatedOn;
import br.com.mind5.business.customer.model.action.CusVisiEnforceLChanged;
import br.com.mind5.business.customer.model.action.CusVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CusNodeInsert extends DeciTreeTemplateWrite<CusInfo> {

	public CusNodeInsert(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();

		ActionStd <CusInfo> nodeSytotin      = new CusNodeSytotinL1(option).toAction();
		ActionLazy<CusInfo> enforceLChanged  = new ActionLazyCommom<CusInfo>(option, CusVisiEnforceLChanged.class);
		ActionLazy<CusInfo> mergeLChangedBy  = new ActionLazyCommom<CusInfo>(option, CusVisiMergeUsername.class);	
		ActionLazy<CusInfo> enforceCreatedBy = new ActionLazyCommom<CusInfo>(option, CusVisiEnforceCreatedBy.class);
		ActionLazy<CusInfo> enforceCreatedOn = new ActionLazyCommom<CusInfo>(option, CusVisiEnforceCreatedOn.class);
		ActionLazy<CusInfo> insertCustomer   = new ActionLazyCommom<CusInfo>(option, CusVisiDaoInsert.class);
		
		nodeSytotin.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeLChangedBy);
		mergeLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insertCustomer);
		
		actions.add(nodeSytotin);
		return actions;
	}
}
