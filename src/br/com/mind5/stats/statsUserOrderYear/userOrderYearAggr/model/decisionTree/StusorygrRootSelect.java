package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.info.StusorygrInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.model.action.StusorygrVisiMergeToSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.model.checker.StusorygrCheckRead;


public final class StusorygrRootSelect extends DeciTreeTemplateWrite<StusorygrInfo> {
	
	public StusorygrRootSelect(DeciTreeOption<StusorygrInfo> option) {
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

		ActionStd<StusorygrInfo> select = new ActionStdCommom<StusorygrInfo>(option, StusorygrVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
