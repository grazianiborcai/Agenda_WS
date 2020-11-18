package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpDaoInsert;
import br.com.mind5.business.employee.model.action.LazyEmpEnforceCreatedBy;
import br.com.mind5.business.employee.model.action.LazyEmpEnforceCreatedOn;
import br.com.mind5.business.employee.model.action.LazyEmpMergeSytotauh;
import br.com.mind5.business.employee.model.action.LazyEmpMergeUsername;
import br.com.mind5.business.employee.model.action.StdEmpEnforceLChanged;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeEmpInsertL1 extends DeciTreeTemplateWrite<EmpInfo> {	
	
	public NodeEmpInsertL1(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {		
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();		
		
		ActionStd<EmpInfo> enforceLChanged = new StdEmpEnforceLChanged(option);
		ActionLazy<EmpInfo> enforceLChangedBy = new LazyEmpMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmpInfo> enforceCreatedBy = new LazyEmpEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<EmpInfo> enforceCreatedOn = new LazyEmpEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<EmpInfo> mergeSytotauh = new LazyEmpMergeSytotauh(option.conn, option.schemaName);
		ActionLazy<EmpInfo> insertEmployee = new LazyEmpDaoInsert(option.conn, option.schemaName);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(mergeSytotauh);
		mergeSytotauh.addPostAction(insertEmployee);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
