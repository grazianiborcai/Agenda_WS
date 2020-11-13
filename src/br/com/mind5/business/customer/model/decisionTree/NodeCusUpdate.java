package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusDaoUpdate;
import br.com.mind5.business.customer.model.action.LazyCusEnforceLChanged;
import br.com.mind5.business.customer.model.action.LazyCusMergeUsername;
import br.com.mind5.business.customer.model.action.LazyCusNodeSytotauh;
import br.com.mind5.business.customer.model.action.StdCusMergeToUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeCusUpdate extends DeciTreeTemplateWrite<CusInfo> {
	
	public NodeCusUpdate(DeciTreeOption<CusInfo> option) {
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

		ActionStd<CusInfo> mergeToUpdate = new StdCusMergeToUpdate(option);
		ActionLazy<CusInfo> nodeSytotauh = new LazyCusNodeSytotauh(option.conn, option.schemaName);
		ActionLazy<CusInfo> enforceLChanged = new LazyCusEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<CusInfo> enforceLChangedBy = new LazyCusMergeUsername(option.conn, option.schemaName);
		ActionLazy<CusInfo> updateCustomer = new LazyCusDaoUpdate(option.conn, option.schemaName);		
		
		mergeToUpdate.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateCustomer);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
