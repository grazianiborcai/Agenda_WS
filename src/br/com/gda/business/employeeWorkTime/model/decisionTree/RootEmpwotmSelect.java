package br.com.gda.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.action.LazyEmpwotmMergeTimezone;
import br.com.gda.business.employeeWorkTime.model.action.LazyEmpwotmMergeWeekday;
import br.com.gda.business.employeeWorkTime.model.action.StdEmpwotmSelect;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckLangu;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmpwotmSelect extends DeciTreeReadTemplate<EmpwotmInfo> {
	
	public RootEmpwotmSelect(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwotmInfo> buildDecisionCheckerHook(DeciTreeOption<EmpwotmInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotmInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new EmpwotmCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpwotmCheckLangu(checkerOption);
		queue.add(checker);		
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwotmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwotmInfo> select = new StdEmpwotmSelect(option);
		ActionLazy<EmpwotmInfo> mergeWeekday = new LazyEmpwotmMergeWeekday(option.conn, option.schemaName);
		ActionLazy<EmpwotmInfo> mergeTimezone = new LazyEmpwotmMergeTimezone(option.conn, option.schemaName);
		
		select.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeTimezone);
		
		actions.add(select);
		return actions;
	}
}
