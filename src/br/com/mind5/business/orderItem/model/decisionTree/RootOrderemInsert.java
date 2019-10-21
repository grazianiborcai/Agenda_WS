package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeMat;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeUsername;
import br.com.mind5.business.orderItem.model.action.LazyOrderemNodeInsert;
import br.com.mind5.business.orderItem.model.action.LazyOrderemNodeSnapshot;
import br.com.mind5.business.orderItem.model.action.StdOrderemEnforceLChanged;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckLangu;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckMat;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckOrder;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckOwner;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

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
		
		ActionStd<OrderemInfo> enforceLChanged = new StdOrderemEnforceLChanged(option);
		ActionLazy<OrderemInfo> mergeUsername = new LazyOrderemMergeUsername(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> mergeMat = new LazyOrderemMergeMat(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> nodeInsert = new LazyOrderemNodeInsert(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> nodeSnapshot = new LazyOrderemNodeSnapshot(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(mergeUsername);
		mergeUsername.addPostAction(mergeMat);
		mergeMat.addPostAction(nodeInsert);
		nodeInsert.addPostAction(nodeSnapshot);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
