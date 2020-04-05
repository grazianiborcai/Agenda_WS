package br.com.mind5.business.orderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.action.LazyOrderemMergeMatlis;
import br.com.mind5.business.orderItem.model.action.LazyOrderemNodeSelect;
import br.com.mind5.business.orderItem.model.action.StdOrderemMergeToSelect;
import br.com.mind5.business.orderItem.model.checker.OrderemCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOrderemSelect extends DeciTreeWriteTemplate<OrderemInfo> {
	
	public RootOrderemSelect(DeciTreeOption<OrderemInfo> option) {
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
		checker = new OrderemCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrderemInfo>> buildActionsOnPassedHook(DeciTreeOption<OrderemInfo> option) {
		List<ActionStdV1<OrderemInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OrderemInfo> select = new StdOrderemMergeToSelect(option);
		ActionLazyV1<OrderemInfo> mergeMatlis = new LazyOrderemMergeMatlis(option.conn, option.schemaName);
		ActionLazyV1<OrderemInfo> nodeSelect = new LazyOrderemNodeSelect(option.conn, option.schemaName);		
		
		select.addPostAction(mergeMatlis);
		mergeMatlis.addPostAction(nodeSelect);
		
		actions.add(select);
		return actions;
	}
}
