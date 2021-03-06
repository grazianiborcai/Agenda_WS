package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpDaoUpdate;
import br.com.mind5.business.employee.model.action.LazyEmpMergeUselis;
import br.com.mind5.business.employee.model.action.LazyEmpNodeInsertUserL2;
import br.com.mind5.business.employee.model.action.LazyEmpUserPromote;
import br.com.mind5.business.employee.model.action.StdEmpMergeUserarch;
import br.com.mind5.business.employee.model.action.StdEmpUserInsert;
import br.com.mind5.business.employee.model.checker.EmpCheckUserarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeEmpInsertUserL1 extends DeciTreeTemplateWrite<EmpInfo> {
	
	public NodeEmpInsertUserL1(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;	
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckUserarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpInfo> mergeUserarch = new StdEmpMergeUserarch(option);
		ActionLazy<EmpInfo> promoteUser = new LazyEmpUserPromote(option.conn, option.schemaName);
		ActionLazy<EmpInfo> updateEmployee = new LazyEmpDaoUpdate(option.conn, option.schemaName);
		ActionLazy<EmpInfo> mergeUselis = new LazyEmpMergeUselis(option.conn, option.schemaName);
		ActionLazy<EmpInfo> nodeL2 = new LazyEmpNodeInsertUserL2(option.conn, option.schemaName);
		
		mergeUserarch.addPostAction(promoteUser);
		promoteUser.addPostAction(updateEmployee);
		updateEmployee.addPostAction(mergeUselis);
		mergeUselis.addPostAction(nodeL2);
		
		actions.add(mergeUserarch);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnFailedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpInfo> insertUser = new StdEmpUserInsert(option);
		ActionLazy<EmpInfo> updateEmployee = new LazyEmpDaoUpdate(option.conn, option.schemaName);
		
		insertUser.addPostAction(updateEmployee);
		
		actions.add(insertUser);	
		return actions;
	}
}
