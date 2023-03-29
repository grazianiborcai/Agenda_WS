package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.OrderemVisiEnforceLChanged;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeOrdist;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeOrdugeCreate;
import br.com.mind5.business.orderItem.model.action.OrderemVisiMergeUsername;
import br.com.mind5.business.orderItem.model.action.OrderemVisiNodeInsert;
import br.com.mind5.business.orderItem.model.action.OrderemVisiNodeSnapshot;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckExist;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckInsert;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckLangu;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckMat;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckOrder;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class OrderemRootInsert extends DeciTreeTemplateWrite<OrderemInfo> {
	
	public OrderemRootInsert(DeciTreeOption<OrderemInfo> option) {
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
		checker = new OrderemCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderemCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderemCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderemCheckOrder(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrderemCheckMat(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new OrderemCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStd<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStd <OrderemInfo> enforceLChanged = new ActionStdCommom <OrderemInfo>(option, OrderemVisiEnforceLChanged.class);
		ActionLazy<OrderemInfo> mergeUsername   = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiMergeUsername.class);
		ActionLazy<OrderemInfo> mergeOrdist     = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiMergeOrdist.class);
		ActionLazy<OrderemInfo> statusChange    = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiMergeOrdugeCreate.class);
		ActionLazy<OrderemInfo> nodeInsert      = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiNodeInsert.class);
		ActionLazy<OrderemInfo> nodeSnapshot    = new ActionLazyCommom<OrderemInfo>(option, OrderemVisiNodeSnapshot.class);
		
		enforceLChanged.addPostAction(mergeUsername);
		mergeUsername.addPostAction(mergeOrdist);
		mergeOrdist.addPostAction(statusChange);
		statusChange.addPostAction(nodeInsert);
		nodeInsert.addPostAction(nodeSnapshot);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
