package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.model.checker.StusoryrchCheckRead;


public final class StusoryrchRootSelectByUser extends DeciTreeTemplateWrite<StusoryrchInfo> {
	
	public StusoryrchRootSelectByUser(DeciTreeOption<StusoryrchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusoryrchInfo> buildCheckerHook(DeciTreeOption<StusoryrchInfo> option) {
		List<ModelChecker<StusoryrchInfo>> queue = new ArrayList<>();		
		ModelChecker<StusoryrchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusoryrchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusoryrchInfo>> buildActionsOnPassedHook(DeciTreeOption<StusoryrchInfo> option) {
		List<ActionStd<StusoryrchInfo>> actions = new ArrayList<>();

		ActionStd<StusoryrchInfo> nodeL1 = new StusoryrchNodeSelectByUser(option).toAction();
		
		actions.add(nodeL1);
		return actions;
	}
}
