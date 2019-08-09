package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.action.LazyEmpEnforceUserCateg;
import br.com.gda.business.employee.model.action.LazyEmpInsertUser;
import br.com.gda.business.employee.model.action.LazyEmpUpdate;
import br.com.gda.business.employee.model.action.StdEmpEnforceAuthGroup;
import br.com.gda.business.employee.model.checker.EmpCheckDummy;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeEmpInsertUser extends DeciTreeWriteTemplate<EmpInfo> {
	
	public NodeEmpInsertUser(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildDecisionCheckerHook(DeciTreeOption<EmpInfo> option) {
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;	
		
		checker = new EmpCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpInfo> enforceAuthGroup = new StdEmpEnforceAuthGroup(option);
		ActionLazy<EmpInfo> enforceUserCateg = new LazyEmpEnforceUserCateg(option.conn, option.schemaName);
		ActionLazy<EmpInfo> insertUser = new LazyEmpInsertUser(option.conn, option.schemaName);
		ActionLazy<EmpInfo> updateEmployee = new LazyEmpUpdate(option.conn, option.schemaName);
		
		enforceAuthGroup.addPostAction(enforceUserCateg);	
		enforceUserCateg.addPostAction(insertUser);	
		insertUser.addPostAction(updateEmployee);
		
		actions.add(enforceAuthGroup);	
		return actions;
	}
}
