package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.checker.StusorygeCheckRead;


public final class StusorygeRootUpsert extends DeciTreeTemplateWrite<StusorygeInfo> {
	
	public StusorygeRootUpsert(DeciTreeOption<StusorygeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorygeInfo> buildCheckerHook(DeciTreeOption<StusorygeInfo> option) {
		List<ModelChecker<StusorygeInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorygeInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusorygeCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorygeInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorygeInfo> option) {
		List<ActionStd<StusorygeInfo>> actions = new ArrayList<>();

		ActionStd<StusorygeInfo> nodeL1 = new StusorygeNodeUpsert(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
