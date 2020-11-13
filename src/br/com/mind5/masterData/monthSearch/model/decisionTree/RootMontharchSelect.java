package br.com.mind5.masterData.monthSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.monthSearch.info.MontharchInfo;
import br.com.mind5.masterData.monthSearch.model.action.StdMontharchDaoSelect;
import br.com.mind5.masterData.monthSearch.model.checker.MontharchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMontharchSelect extends DeciTreeTemplateReadV2<MontharchInfo> {
	
	public RootMontharchSelect(DeciTreeOption<MontharchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MontharchInfo> buildCheckerHook(DeciTreeOption<MontharchInfo> option) {
		List<ModelCheckerV1<MontharchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MontharchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MontharchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<MontharchInfo>> buildActionsOnPassedHook(DeciTreeOption<MontharchInfo> option) {
		List<ActionStdV2<MontharchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<MontharchInfo> select = new StdMontharchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
