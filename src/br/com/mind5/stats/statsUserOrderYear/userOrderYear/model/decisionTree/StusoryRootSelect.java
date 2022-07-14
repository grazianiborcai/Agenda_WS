package br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.info.StusoryInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYear.model.checker.StusoryCheckRead;


public final class StusoryRootSelect extends DeciTreeTemplateWrite<StusoryInfo> {
	
	public StusoryRootSelect(DeciTreeOption<StusoryInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusoryInfo> buildCheckerHook(DeciTreeOption<StusoryInfo> option) {
		List<ModelChecker<StusoryInfo>> queue = new ArrayList<>();		
		ModelChecker<StusoryInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusoryCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusoryInfo>> buildActionsOnPassedHook(DeciTreeOption<StusoryInfo> option) {
		List<ActionStd<StusoryInfo>> actions = new ArrayList<>();

		ActionStd<StusoryInfo> nodeL1 = new StusoryNodeSelectL1(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
