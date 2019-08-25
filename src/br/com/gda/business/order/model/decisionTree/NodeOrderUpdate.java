package br.com.gda.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.action.LazyOrderEnforceLChanged;
import br.com.gda.business.order.model.action.LazyOrderNodePayord;
import br.com.gda.business.order.model.action.LazyOrderNodeSnapshot;
import br.com.gda.business.order.model.checker.OrderCheckUpdate;
import br.com.gda.business.order.model.action.StdOrderMergeUsername;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOrderUpdate extends DeciTreeWriteTemplate<OrderInfo> {
	
	public NodeOrderUpdate(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildDecisionCheckerHook(DeciTreeOption<OrderInfo> option) {
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		
		checker = new OrderCheckUpdate();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();

		ActionStd<OrderInfo> mergeUsername = new StdOrderMergeUsername(option);
		ActionLazy<OrderInfo> enforceLChanged = new LazyOrderEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<OrderInfo> nodePayord = new LazyOrderNodePayord(option.conn, option.schemaName);
		ActionLazy<OrderInfo> snapshot = new LazyOrderNodeSnapshot(option.conn, option.schemaName);
		
		mergeUsername.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(nodePayord);		
		nodePayord.addPostAction(snapshot);
		
		actions.add(mergeUsername);
		return actions;
	}
}
