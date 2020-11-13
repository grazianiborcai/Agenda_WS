package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeOrdugeCreate;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeUsername;
import br.com.mind5.business.orderItem.model.action.LazyOrderemNodeInsert;
import br.com.mind5.business.orderItem.model.action.LazyOrderemNodeSnapshot;
import br.com.mind5.business.orderItem.model.action.StdOrderemEnforceLChanged;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckExist;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckInsert;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckLangu;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckMat;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckOrder;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootOrderemInsert extends DeciTreeTemplateWriteV2<OrderemInfo> {
	
	public RootOrderemInsert(DeciTreeOption<OrderemInfo> option) {
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStdV1<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrderemInfo> enforceLChanged = new StdOrderemEnforceLChanged(option);
		ActionLazy<OrderemInfo> mergeUsername = new LazyOrderemMergeUsername(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> statusChange = new LazyOrderemMergeOrdugeCreate(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> nodeInsert = new LazyOrderemNodeInsert(option.conn, option.schemaName);
		ActionLazy<OrderemInfo> nodeSnapshot = new LazyOrderemNodeSnapshot(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(mergeUsername);
		mergeUsername.addPostAction(statusChange);
		statusChange.addPostAction(nodeInsert);
		nodeInsert.addPostAction(nodeSnapshot);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
