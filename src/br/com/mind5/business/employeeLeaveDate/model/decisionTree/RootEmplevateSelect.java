package br.com.mind5.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.model.action.LazyEmplevateMergeTimezone;
import br.com.mind5.business.employeeLeaveDate.model.action.StdEmplevateMergeToSelect;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckLangu;
import br.com.mind5.business.employeeLeaveDate.model.checker.EmplevateCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public class RootEmplevateSelect extends DeciTreeReadTemplate<EmplevateInfo> {
	
	public RootEmplevateSelect(DeciTreeOption<EmplevateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplevateInfo> buildDecisionCheckerHook(DeciTreeOption<EmplevateInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<EmplevateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplevateInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new EmplevateCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplevateCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplevateInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplevateInfo> option) {
		List<ActionStd<EmplevateInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplevateInfo> select = new StdEmplevateMergeToSelect(option);
		ActionLazy<EmplevateInfo> mergeTimezone = new LazyEmplevateMergeTimezone(option.conn, option.schemaName);
		
		select.addPostAction(mergeTimezone);
		
		actions.add(select);
		return actions;
	}
}
