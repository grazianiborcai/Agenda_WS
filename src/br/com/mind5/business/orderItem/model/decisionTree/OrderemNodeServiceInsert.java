package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.OrderemVisiNodeCus;
import br.com.mind5.business.orderItem.model.action.OrderemVisiDaoInsert;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeRefupore;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeStolis;
import br.com.mind5.business.orderItem.model.action.OrderemVisiSchedineInsert;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckEmp;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckEmpmat;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckEmposarch;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckInsertService;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckMatore;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrderemNodeServiceInsert extends DeciTreeTemplateWrite<OrderemInfo> {
	
	public OrderemNodeServiceInsert(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderemInfo> buildCheckerHook(DeciTreeOption<OrderemInfo> option) {
		List<ModelChecker<OrderemInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new OrderemCheckInsertService(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderemCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderemCheckMatore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderemCheckEmp(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderemCheckEmposarch(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderemCheckEmpmat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderemInfo> mergeStolis = new ActionStdCommom<OrderemInfo>(option, OrderemVisiMergeStolis.class);	
		ActionLazy<OrderemInfo> mergeRefupore = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiMergeRefupore.class);
		ActionLazy<OrderemInfo> insert = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiDaoInsert.class);
		ActionLazy<OrderemInfo> nodeCus = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiNodeCus.class);
		ActionLazy<OrderemInfo> schedineInsert = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiSchedineInsert.class);
		
		mergeStolis.addPostAction(mergeRefupore);
		mergeRefupore.addPostAction(insert);
		insert.addPostAction(nodeCus);
		nodeCus.addPostAction(schedineInsert);
		
		actions.add(mergeStolis);		
		return actions;
	}
}
