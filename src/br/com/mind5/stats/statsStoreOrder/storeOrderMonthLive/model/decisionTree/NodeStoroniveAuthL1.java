package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action.StdStoroniveSuccess;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.checker.StoroniveCheckAuthOwner;

public final class NodeStoroniveAuthL1 extends DeciTreeTemplateWrite<StoroniveInfo> {
	
	public NodeStoroniveAuthL1(DeciTreeOption<StoroniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoroniveInfo> buildCheckerHook(DeciTreeOption<StoroniveInfo> option) {
		List<ModelChecker<StoroniveInfo>> queue = new ArrayList<>();
		ModelChecker<StoroniveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StoroniveCheckAuthOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoroniveInfo>> buildActionsOnPassedHook(DeciTreeOption<StoroniveInfo> option) {
		List<ActionStd<StoroniveInfo>> actions = new ArrayList<>();
		
		ActionStd<StoroniveInfo> success = new StdStoroniveSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoroniveInfo>> buildActionsOnFailedHook(DeciTreeOption<StoroniveInfo> option) {
		List<ActionStd<StoroniveInfo>> actions = new ArrayList<>();
		
		ActionStd<StoroniveInfo> nodeL2 = new NodeStoroniveAuthL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
