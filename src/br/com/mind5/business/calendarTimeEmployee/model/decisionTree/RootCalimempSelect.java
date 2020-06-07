package br.com.mind5.business.calendarTimeEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeEmployee.model.action.LazyCalimempNodeSelect;
import br.com.mind5.business.calendarTimeEmployee.model.action.StdCalimempMergeCalate;
import br.com.mind5.business.calendarTimeEmployee.model.checker.CalimempCheckEmp;
import br.com.mind5.business.calendarTimeEmployee.model.checker.CalimempCheckOwner;
import br.com.mind5.business.calendarTimeEmployee.model.checker.CalimempCheckRead;
import br.com.mind5.business.calendarTimeEmployee.model.checker.CalimempCheckStore;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootCalimempSelect extends DeciTreeTemplateWriteV2<CalimempInfo> {
	
	public RootCalimempSelect(DeciTreeOption<CalimempInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CalimempInfo> buildCheckerHook(DeciTreeOption<CalimempInfo> option) {
		List<ModelCheckerV1<CalimempInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CalimempInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalimempCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalimempCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalimempCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CalimempCheckEmp(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CalimempInfo>> buildActionsOnPassedHook(DeciTreeOption<CalimempInfo> option) {
		List<ActionStdV1<CalimempInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CalimempInfo> mergeCalate = new StdCalimempMergeCalate(option);
		ActionLazyV1<CalimempInfo> select = new LazyCalimempNodeSelect(option.conn, option.schemaName);
		
		mergeCalate.addPostAction(select);
		
		actions.add(mergeCalate);
		return actions;
	}
}
