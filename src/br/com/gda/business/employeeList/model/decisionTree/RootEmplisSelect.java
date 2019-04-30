package br.com.gda.business.employeeList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.employeeList.model.action.LazyEmplisMergePerson;
import br.com.gda.business.employeeList.model.action.StdEmplisMergeToSelect;
import br.com.gda.business.employeeList.model.checker.EmplisCheckLangu;
import br.com.gda.business.employeeList.model.checker.EmplisCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmplisSelect extends DeciTreeReadTemplate<EmplisInfo> {
	
	public RootEmplisSelect(DeciTreeOption<EmplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplisInfo> buildDecisionCheckerHook(DeciTreeOption<EmplisInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<EmplisInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplisInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checker = new EmplisCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplisCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplisInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplisInfo> option) {
		List<ActionStd<EmplisInfo>> actions = new ArrayList<>();

		ActionStd<EmplisInfo> select = new StdEmplisMergeToSelect(option);
		ActionLazy<EmplisInfo> mergePerson = new LazyEmplisMergePerson(option.conn, option.schemaName);
		
		select.addPostAction(mergePerson);
		
		actions.add(select);
		return actions;
	}
}
