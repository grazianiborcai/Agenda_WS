package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.checker.StordCheckWrite;


public final class StordRootUpsert extends DeciTreeTemplateWrite<StordInfo> {
	
	public StordRootUpsert(DeciTreeOption<StordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StordInfo> buildCheckerHook(DeciTreeOption<StordInfo> option) {
		List<ModelChecker<StordInfo>> queue = new ArrayList<>();
		ModelChecker<StordInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StordCheckWrite(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StordInfo>> buildActionsOnPassedHook(DeciTreeOption<StordInfo> option) {
		List<ActionStd<StordInfo>> actions = new ArrayList<>();

		ActionStd<StordInfo> nodeL1 = new StordNodeUpsert(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
