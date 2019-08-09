package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.action.LazyEmpInsertEmpnap;
import br.com.gda.business.employee.model.action.LazyEmpUpdate;
import br.com.gda.business.employee.model.action.LazyEmpUpdatePerson;
import br.com.gda.business.employee.model.action.StdEmpEnforcePersonKey;
import br.com.gda.business.employee.model.action.StdEmpSuccess;
import br.com.gda.business.employee.model.checker.EmpCheckHasPerson;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeEmpUpdatePerson extends DeciTreeWriteTemplate<EmpInfo> {
	
	public NodeEmpUpdatePerson(DeciTreeOption<EmpInfo> option) {
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
		
		ActionStd<EmpInfo> enforcePersonKey = new StdEmpEnforcePersonKey(option);
		ActionLazy<EmpInfo> updatePerson = new LazyEmpUpdatePerson(option.conn, option.schemaName);
		ActionLazy<EmpInfo> insertEmpnap = new LazyEmpInsertEmpnap(option.conn, option.schemaName);	
		ActionLazy<EmpInfo> updateEnployee = new LazyEmpUpdate(option.conn, option.schemaName);	
		
		enforcePersonKey.addPostAction(updatePerson);
		updatePerson.addPostAction(insertEmpnap);
		insertEmpnap.addPostAction(updateEnployee);
		
		actions.add(enforcePersonKey);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmpSuccess(option));		
		return actions;
	}
}
