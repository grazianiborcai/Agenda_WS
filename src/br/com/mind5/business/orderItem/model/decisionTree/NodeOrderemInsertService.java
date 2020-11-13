package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemDaoInsert;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeRefupore;
import br.com.mind5.business.orderItem.model.action.LazyOrderemSchedineInsert;
import br.com.mind5.business.orderItem.model.action.StdOrderemMergeStolis;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckEmp;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckEmpmat;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckEmposarch;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckInsertService;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckMatore;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeOrderemInsertService extends DeciTreeTemplateWrite<OrderemInfo> {
	
	public NodeOrderemInsertService(DeciTreeOption<OrderemInfo> option) {
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
		
		ActionStd<OrderemInfo> mergeStolis = new StdOrderemMergeStolis(option);	
		ActionLazy<OrderemInfo> mergeRefupore = new LazyOrderemMergeRefupore(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> insert = new LazyOrderemDaoInsert(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> schedineInsert = new LazyOrderemSchedineInsert(option.conn, option.schemaName);
		
		mergeStolis.addPostAction(mergeRefupore);
		mergeRefupore.addPostAction(insert);
		insert.addPostAction(schedineInsert);
		
		actions.add(mergeStolis);		
		return actions;
	}
}
