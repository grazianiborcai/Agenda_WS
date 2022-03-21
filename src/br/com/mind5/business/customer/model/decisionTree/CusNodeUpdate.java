package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.CusVisiNodeSytotauh;
import br.com.mind5.business.customer.model.action.CusVisiDaoUpdate;
import br.com.mind5.business.customer.model.action.CusVisiEnforceLChanged;
import br.com.mind5.business.customer.model.action.CusVisiMergeToUpdate;
import br.com.mind5.business.customer.model.action.CusVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CusNodeUpdate extends DeciTreeTemplateWrite<CusInfo> {
	
	public CusNodeUpdate(DeciTreeOption<CusInfo> option) {
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

		ActionStd<CusInfo> mergeToUpdate = new ActionStdCommom<CusInfo>(option, CusVisiMergeToUpdate.class);
		ActionLazy<CusInfo> nodeSytotauh = new ActionLazyCommom<CusInfo>(option, CusVisiNodeSytotauh.class);
		ActionLazy<CusInfo> enforceLChanged = new ActionLazyCommom<CusInfo>(option,CusVisiEnforceLChanged.class);
		ActionLazy<CusInfo> enforceLChangedBy = new ActionLazyCommom<CusInfo>(option, CusVisiMergeUsername.class);
		ActionLazy<CusInfo> updateCustomer = new ActionLazyCommom<CusInfo>(option, CusVisiDaoUpdate.class);		
		
		mergeToUpdate.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateCustomer);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
