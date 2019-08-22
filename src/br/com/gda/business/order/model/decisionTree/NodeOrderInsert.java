package br.com.gda.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.action.LazyOrderEnforceExtid;
import br.com.gda.business.order.model.action.LazyOrderEnforceLChanged;
import br.com.gda.business.order.model.action.StdOrderMergeUsername;
import br.com.gda.business.order.model.action.LazyOrderEnforceStatusCreated;
import br.com.gda.business.order.model.action.LazyOrderInsert;
import br.com.gda.business.order.model.action.LazyOrderMergeCusarch;
import br.com.gda.business.order.model.action.LazyOrderMergeUselis;
import br.com.gda.business.order.model.checker.OrderCheckInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderInsert extends DeciTreeWriteTemplate<OrderInfo> {
	
	public NodeOrderInsert(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildDecisionCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		
		checker = new OrderCheckInsert();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();
		//TODO: zerar Address e Phone - Somente aceitar no Place
		ActionStd<OrderInfo> mergeUsername = new StdOrderMergeUsername(option);
		ActionLazy<OrderInfo> mergeUselis = new LazyOrderMergeUselis(option.conn, option.schemaName);
		ActionLazy<OrderInfo> mergeCusarch = new LazyOrderMergeCusarch(option.conn, option.schemaName);
		ActionLazy<OrderInfo> enforceLChanged = new LazyOrderEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<OrderInfo> enforceExtid = new LazyOrderEnforceExtid(option.conn, option.schemaName);
		ActionLazy<OrderInfo> enforceStatus = new LazyOrderEnforceStatusCreated(option.conn, option.schemaName);
		ActionLazy<OrderInfo> insert = new LazyOrderInsert(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(mergeUselis);
		mergeUselis.addPostAction(mergeCusarch);
		mergeCusarch.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceExtid);
		enforceExtid.addPostAction(enforceStatus);		
		enforceStatus.addPostAction(insert);
		
		actions.add(mergeUsername);
		return actions;
	}
}
