package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpInsertPerson;
import br.com.mind5.business.employee.model.action.LazyEmpUpdate;
import br.com.mind5.business.employee.model.action.StdEmpEnforcePersonKey;
import br.com.mind5.business.employee.model.checker.EmpCheckHasPerson;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeEmpInsertPerson extends DeciTreeWriteTemplate<EmpInfo> {
	
	public NodeEmpInsertPerson(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildDecisionCheckerHook(DeciTreeOption<EmpInfo> option) {
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmpCheckHasPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpInfo> enforcePersonKey = new StdEmpEnforcePersonKey(option);
		ActionLazy<EmpInfo> insertPerson = new LazyEmpInsertPerson(option.conn, option.schemaName);
		ActionLazy<EmpInfo> updateEmployee = new LazyEmpUpdate(option.conn, option.schemaName);
		
		enforcePersonKey.addPostAction(insertPerson);
		insertPerson.addPostAction(updateEmployee);
		
		actions.add(enforcePersonKey);
		return actions;
	}
}
