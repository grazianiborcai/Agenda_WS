package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.action.LazyEmpEnforcePersonKey;
import br.com.gda.business.employee.model.action.LazyEmpInsertPerson;
import br.com.gda.business.employee.model.action.LazyEmpUpdate;
import br.com.gda.business.employee.model.action.StdEmpEnforceEntityCateg;
import br.com.gda.business.employee.model.checker.EmpCheckHasPerson;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeEmpInsertPerson extends DeciTreeWriteTemplate<EmpInfo> {
	
	public NodeEmpInsertPerson(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildDecisionCheckerHook(DeciTreeOption<EmpInfo> option) {
		final boolean HAS_PERSON = true;
		
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_PERSON;		
		checker = new EmpCheckHasPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpInfo> enforceEntityCateg = new StdEmpEnforceEntityCateg(option);
		ActionLazy<EmpInfo> enforcePersonKey = new LazyEmpEnforcePersonKey(option.conn, option.schemaName);
		ActionLazy<EmpInfo> insertPerson = new LazyEmpInsertPerson(option.conn, option.schemaName);
		ActionLazy<EmpInfo> updateEmployee = new LazyEmpUpdate(option.conn, option.schemaName);
		
		enforceEntityCateg.addPostAction(enforcePersonKey);
		enforcePersonKey.addPostAction(insertPerson);
		insertPerson.addPostAction(updateEmployee);
		
		actions.add(enforceEntityCateg);
		return actions;
	}
}
