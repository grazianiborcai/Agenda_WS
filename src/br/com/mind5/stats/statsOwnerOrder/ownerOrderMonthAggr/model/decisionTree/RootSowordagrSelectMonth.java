package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action.LazySowordagrRootSelect;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action.StdSowordagrMergeSowordarchMonth;


public final class RootSowordagrSelectMonth extends DeciTreeTemplateWrite<SowordagrInfo> {
	
	public RootSowordagrSelectMonth(DeciTreeOption<SowordagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowordagrInfo> buildCheckerHook(DeciTreeOption<SowordagrInfo> option) {
		List<ModelChecker<SowordagrInfo>> queue = new ArrayList<>();
		ModelChecker<SowordagrInfo> checker;

		checker = new ModelCheckerDummy<SowordagrInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowordagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowordagrInfo> option) {
		List<ActionStd<SowordagrInfo>> actions = new ArrayList<>();

		ActionStd<SowordagrInfo> mergeSowordarchMonth = new StdSowordagrMergeSowordarchMonth(option);
		ActionLazy<SowordagrInfo> select = new LazySowordagrRootSelect(option.conn, option.schemaName);
		
		mergeSowordarchMonth.addPostAction(select);
		
		actions.add(mergeSowordarchMonth);
		return actions;
	}
}
