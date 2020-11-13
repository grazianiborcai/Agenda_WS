package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpDaoInsert;
import br.com.mind5.business.employee.model.action.LazyEmpEnforceCreatedBy;
import br.com.mind5.business.employee.model.action.LazyEmpEnforceCreatedOn;
import br.com.mind5.business.employee.model.action.LazyEmpMergeSytotauh;
import br.com.mind5.business.employee.model.action.LazyEmpMergeUsername;
import br.com.mind5.business.employee.model.action.LazyEmpNodeInsertL2;
import br.com.mind5.business.employee.model.action.StdEmpEnforceLChanged;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeEmpInsertL1 extends DeciTreeTemplateWriteV2<EmpInfo> {	
	
	public NodeEmpInsertL1(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {		
		List<ModelCheckerV1<EmpInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStdV1<EmpInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<EmpInfo> enforceLChanged = new StdEmpEnforceLChanged(option);
		ActionLazy<EmpInfo> enforceLChangedBy = new LazyEmpMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmpInfo> enforceCreatedBy = new LazyEmpEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<EmpInfo> enforceCreatedOn = new LazyEmpEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<EmpInfo> mergeSytotauh = new LazyEmpMergeSytotauh(option.conn, option.schemaName);
		ActionLazy<EmpInfo> insertEmployee = new LazyEmpDaoInsert(option.conn, option.schemaName);
		ActionLazy<EmpInfo> nodeL2 = new LazyEmpNodeInsertL2(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(mergeSytotauh);
		mergeSytotauh.addPostAction(insertEmployee);
		insertEmployee.addPostAction(nodeL2);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
