package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemInsert;
import br.com.mind5.business.orderItem.model.action.StdOrderemMergeStolis;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckEmp;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckEmpmat;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckEmposarch;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckMatore;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckStore;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckInsertService;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeOrderemInsertService extends DeciTreeTemplateWrite<OrderemInfo> {
	
	public NodeOrderemInsertService(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrderemInfo> buildCheckerHook(DeciTreeOption<OrderemInfo> option) {
		List<ModelCheckerV1<OrderemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrderemInfo> checker;	
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStdV1<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrderemInfo> mergeStolis = new StdOrderemMergeStolis(option);		
		ActionLazyV1<OrderemInfo> insert = new LazyOrderemInsert(option.conn, option.schemaName);
		
		mergeStolis.addPostAction(insert);
		
		actions.add(mergeStolis);		
		return actions;
	}
}
