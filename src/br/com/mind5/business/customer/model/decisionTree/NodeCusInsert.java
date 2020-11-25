package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusDaoInsert;
import br.com.mind5.business.customer.model.action.LazyCusEnforceCreatedBy;
import br.com.mind5.business.customer.model.action.LazyCusEnforceCreatedOn;
import br.com.mind5.business.customer.model.action.LazyCusEnforceLChanged;
import br.com.mind5.business.customer.model.action.LazyCusMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeCusInsert extends DeciTreeTemplateWrite<CusInfo> {

	public NodeCusInsert(DeciTreeOption<CusInfo> option) {
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

		ActionStd<CusInfo> nodeSytotin = new NodeCusSytotinL1(option).toAction();
		ActionLazy<CusInfo> enforceLChanged = new LazyCusEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<CusInfo> mergeLChangedBy = new LazyCusMergeUsername(option.conn, option.schemaName);	
		ActionLazy<CusInfo> enforceCreatedBy = new LazyCusEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<CusInfo> enforceCreatedOn = new LazyCusEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<CusInfo> insertCustomer = new LazyCusDaoInsert(option.conn, option.schemaName);
		
		nodeSytotin.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeLChangedBy);
		mergeLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insertCustomer);
		
		actions.add(nodeSytotin);
		return actions;
	}
}
