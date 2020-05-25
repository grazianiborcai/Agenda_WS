package br.com.mind5.masterData.month.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.action.StdMonthDaoSelect;
import br.com.mind5.masterData.month.model.checker.MonthCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootMonthSelect extends DeciTreeTemplateReadV2<MonthInfo> {
	
	public RootMonthSelect(DeciTreeOption<MonthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MonthInfo> buildCheckerHook(DeciTreeOption<MonthInfo> option) {
		List<ModelCheckerV1<MonthInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MonthInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MonthCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MonthInfo>> buildActionsOnPassedHook(DeciTreeOption<MonthInfo> option) {
		List<ActionStdV1<MonthInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MonthInfo> select = new StdMonthDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
