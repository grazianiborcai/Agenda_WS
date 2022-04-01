package br.com.mind5.business.calendarTimeEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeEmployee.model.action.CalimempVisiNodeSelect;
import br.com.mind5.business.calendarTimeEmployee.model.action.CalimempVisiMergeCalate;
import br.com.mind5.business.calendarTimeEmployee.model.checker.CalimempCheckEmp;
import br.com.mind5.business.calendarTimeEmployee.model.checker.CalimempCheckOwner;
import br.com.mind5.business.calendarTimeEmployee.model.checker.CalimempCheckRead;
import br.com.mind5.business.calendarTimeEmployee.model.checker.CalimempCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CalimempRootSelect extends DeciTreeTemplateWrite<CalimempInfo> {
	
	public CalimempRootSelect(DeciTreeOption<CalimempInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CalimempInfo> buildCheckerHook(DeciTreeOption<CalimempInfo> option) {
		List<ModelChecker<CalimempInfo>> queue = new ArrayList<>();		
		ModelChecker<CalimempInfo> checker;	
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CalimempInfo>> buildActionsOnPassedHook(DeciTreeOption<CalimempInfo> option) {
		List<ActionStd<CalimempInfo>> actions = new ArrayList<>();
		
		ActionStd<CalimempInfo> mergeCalate = new ActionStdCommom<CalimempInfo>(option, CalimempVisiMergeCalate.class);
		ActionLazy<CalimempInfo> select = new ActionLazyCommom<CalimempInfo>(option, CalimempVisiNodeSelect.class);
		
		mergeCalate.addPostAction(select);
		
		actions.add(mergeCalate);
		return actions;
	}
}
