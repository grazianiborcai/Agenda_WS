package br.com.gda.business.order.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.action.LazyOrderEnforceLChanged;
import br.com.gda.business.order.model.action.LazyOrderEnforceStatusMoip;
import br.com.gda.business.order.model.action.LazyOrderNodePayord;
import br.com.gda.business.order.model.action.LazyOrderRefreshSchedine;
import br.com.gda.business.order.model.checker.OrderCheckLangu;
import br.com.gda.business.order.model.checker.OrderCheckOwner;
import br.com.gda.business.order.model.checker.OrderCheckStatus;
import br.com.gda.business.order.model.checker.OrderCheckUpdate;
import br.com.gda.business.order.model.action.LazyOrderRootSelect;
import br.com.gda.business.order.model.action.LazyOrderUpdate;
import br.com.gda.business.order.model.action.StdOrderMergeToUpdate;
import br.com.gda.business.order.model.checker.OrderCheckExist;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOrderUpdate extends DeciTreeWriteTemplate<OrderInfo> {
	
	public RootOrderUpdate(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderInfo> buildDecisionCheckerHook(DeciTreeOption<OrderInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrderInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrderCheckUpdate();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderCheckStatus(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderInfo> option) {
		List<ActionStd<OrderInfo>> actions = new ArrayList<>();

		ActionStd<OrderInfo> mergeToUpdate = new StdOrderMergeToUpdate(option);
		ActionLazy<OrderInfo> enforceLChanged = new LazyOrderEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<OrderInfo> nodePayord = new LazyOrderNodePayord(option.conn, option.schemaName);
		ActionLazy<OrderInfo> enforceStatus = new LazyOrderEnforceStatusMoip(option.conn, option.schemaName);
		ActionLazy<OrderInfo> update = new LazyOrderUpdate(option.conn, option.schemaName);
		ActionLazy<OrderInfo> refreshSchedine = new LazyOrderRefreshSchedine(option.conn, option.schemaName);
		ActionLazy<OrderInfo> select = new LazyOrderRootSelect(option.conn, option.schemaName);	
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(nodePayord);		
		nodePayord.addPostAction(enforceStatus);		
		enforceStatus.addPostAction(update);
		update.addPostAction(refreshSchedine);
		refreshSchedine.addPostAction(select);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
