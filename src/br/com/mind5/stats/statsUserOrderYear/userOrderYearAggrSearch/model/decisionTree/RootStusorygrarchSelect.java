package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.action.StdStusorygrarchMergeToSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.checker.StusorygrarchCheckRead;


public final class RootStusorygrarchSelect extends DeciTreeTemplateWrite<StusorygrarchInfo> {
	
	public RootStusorygrarchSelect(DeciTreeOption<StusorygrarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorygrarchInfo> buildCheckerHook(DeciTreeOption<StusorygrarchInfo> option) {
		List<ModelChecker<StusorygrarchInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorygrarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusorygrarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorygrarchInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorygrarchInfo> option) {
		List<ActionStd<StusorygrarchInfo>> actions = new ArrayList<>();

		ActionStd<StusorygrarchInfo> select = new StdStusorygrarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
