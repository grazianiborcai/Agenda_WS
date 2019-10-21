package br.com.mind5.business.employeeWorkTimeConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeConflict.model.action.LazyEmpwocoMergeTimezone;
import br.com.mind5.business.employeeWorkTimeConflict.model.action.LazyEmpwocoMergeWeekday;
import br.com.mind5.business.employeeWorkTimeConflict.model.action.StdEmpwocoMergeToSelect;
import br.com.mind5.business.employeeWorkTimeConflict.model.checker.EmpwocoCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmpwocoSelect extends DeciTreeReadTemplate<EmpwocoInfo> {
	
	public RootEmpwocoSelect(DeciTreeOption<EmpwocoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpwocoInfo> buildDecisionCheckerHook(DeciTreeOption<EmpwocoInfo> option) {
		List<ModelChecker<EmpwocoInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwocoInfo> checker;
		
		checker = new EmpwocoCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpwocoInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpwocoInfo> option) {
		List<ActionStd<EmpwocoInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpwocoInfo> select = new StdEmpwocoMergeToSelect(option);
		ActionLazy<EmpwocoInfo> mergeWeekday = new LazyEmpwocoMergeWeekday(option.conn, option.schemaName);
		ActionLazy<EmpwocoInfo> mergeTimezone = new LazyEmpwocoMergeTimezone(option.conn, option.schemaName);
		
		select.addPostAction(mergeWeekday);
		mergeWeekday.addPostAction(mergeTimezone);
		
		actions.add(select);
		return actions;
	}
}
