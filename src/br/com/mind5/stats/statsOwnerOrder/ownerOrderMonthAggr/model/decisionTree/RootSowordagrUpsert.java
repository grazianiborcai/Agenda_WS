package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.checker.SowordagrCheckLangu;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.checker.SowordagrCheckOwner;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.checker.SowordagrCheckWrite;


public final class RootSowordagrUpsert extends DeciTreeTemplateWrite<SowordagrInfo> {
	
	public RootSowordagrUpsert(DeciTreeOption<SowordagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowordagrInfo> buildCheckerHook(DeciTreeOption<SowordagrInfo> option) {
		List<ModelChecker<SowordagrInfo>> queue = new ArrayList<>();
		ModelChecker<SowordagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowordagrCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowordagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowordagrCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowordagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowordagrInfo> option) {
		List<ActionStd<SowordagrInfo>> actions = new ArrayList<>();

		ActionStd<SowordagrInfo> nodeL1 = new NodeSowordagrUpsert(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
