package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.action.StdStusorygerchMergeToSelect;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.checker.StusorygerchCheckRead;


public final class RootStusorygerchSelect extends DeciTreeTemplateWrite<StusorygerchInfo> {
	
	public RootStusorygerchSelect(DeciTreeOption<StusorygerchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorygerchInfo> buildCheckerHook(DeciTreeOption<StusorygerchInfo> option) {
		List<ModelChecker<StusorygerchInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorygerchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusorygerchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorygerchInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorygerchInfo> option) {
		List<ActionStd<StusorygerchInfo>> actions = new ArrayList<>();

		ActionStd<StusorygerchInfo> select = new StdStusorygerchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
