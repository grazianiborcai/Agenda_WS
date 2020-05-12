package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemNodeRefunding;
import br.com.mind5.business.orderItem.model.action.LazyOrderemRootSelect;
import br.com.mind5.business.orderItem.model.action.StdOrderemMergeToSelect;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckExist;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckLangu;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckOwner;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootOrderemRefunding extends DeciTreeTemplateWriteV2<OrderemInfo> {
	
	public RootOrderemRefunding(DeciTreeOption<OrderemInfo> option) {
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
		checker = new OrderemCheckWrite(checkerOption);
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
		checker = new OrderemCheckExist(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStdV1<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrderemInfo> select = new StdOrderemMergeToSelect(option);
		ActionLazyV1<OrderemInfo> nodeRefunding = new LazyOrderemNodeRefunding(option.conn, option.schemaName);
		ActionLazyV1<OrderemInfo> rootSelect = new LazyOrderemRootSelect(option.conn, option.schemaName);	
		
		select.addPostAction(nodeRefunding);
		nodeRefunding.addPostAction(rootSelect);
		
		actions.add(select);
		return actions;
	}
}
