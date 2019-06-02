package br.com.gda.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.orderItem.model.action.LazyOrderemMergeMat;
import br.com.gda.business.orderItem.model.action.LazyOrderemNodeInsert;
import br.com.gda.business.orderItem.model.action.StdOrderemEnforceCreatedOn;
import br.com.gda.business.orderItem.model.checker.OrderemCheckOrder;
import br.com.gda.business.orderItem.model.checker.OrderemCheckLangu;
import br.com.gda.business.orderItem.model.checker.OrderemCheckMat;
import br.com.gda.business.orderItem.model.checker.OrderemCheckOwner;
import br.com.gda.business.orderItem.model.checker.OrderemCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOrderemInsert extends DeciTreeWriteTemplate<OrderemInfo> {
	
	public RootOrderemInsert(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrderemInfo> buildDecisionCheckerHook(DeciTreeOption<OrderemInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrderemInfo>> queue = new ArrayList<>();		
		ModelChecker<OrderemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrderemCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderemCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderemCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderemCheckOrder(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrderemCheckMat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStd<OrderemInfo> enforceCreatedOn = new StdOrderemEnforceCreatedOn(option);
		ActionLazy<OrderemInfo> mergeMat = new LazyOrderemMergeMat(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> nodeInsert = new LazyOrderemNodeInsert(option.conn, option.schemaName);
		
		enforceCreatedOn.addPostAction(mergeMat);
		mergeMat.addPostAction(nodeInsert);
		
		actions.add(enforceCreatedOn);
		return actions;
	}
}
