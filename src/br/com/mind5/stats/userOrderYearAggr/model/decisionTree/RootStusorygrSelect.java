package br.com.mind5.stats.userOrderYearAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.userOrderYearAggr.info.StusorygrInfo;
import br.com.mind5.stats.userOrderYearAggr.model.action.StdStusorygrMergeToSelect;
import br.com.mind5.stats.userOrderYearAggr.model.checker.StusorygrCheckRead;


public final class RootStusorygrSelect extends DeciTreeTemplateWrite<StusorygrInfo> {
	
	public RootStusorygrSelect(DeciTreeOption<StusorygrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorygrInfo> buildCheckerHook(DeciTreeOption<StusorygrInfo> option) {
		List<ModelChecker<StusorygrInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorygrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusorygrCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorygrInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorygrInfo> option) {
		List<ActionStd<StusorygrInfo>> actions = new ArrayList<>();

		ActionStd<StusorygrInfo> select = new StdStusorygrMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
