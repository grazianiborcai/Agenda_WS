package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpEnforceCreatedBy;
import br.com.mind5.business.employee.model.action.LazyEmpEnforceCreatedOn;
import br.com.mind5.business.employee.model.action.LazyEmpInsert;
import br.com.mind5.business.employee.model.action.LazyEmpMergeUsername;
import br.com.mind5.business.employee.model.action.StdEmpEnforceLChanged;
import br.com.mind5.business.employee.model.checker.EmpCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeEmpInsert extends DeciTreeWriteTemplate<EmpInfo> {	
	
	public NodeEmpInsert(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildDecisionCheckerHook(DeciTreeOption<EmpInfo> option) {		
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;	
		
		checker = new EmpCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStdV1<EmpInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<EmpInfo> enforceLChanged = new StdEmpEnforceLChanged(option);
		ActionLazyV1<EmpInfo> enforceLChangedBy = new LazyEmpMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<EmpInfo> enforceCreatedBy = new LazyEmpEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazyV1<EmpInfo> enforceCreatedOn = new LazyEmpEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazyV1<EmpInfo> insertEmployee = new LazyEmpInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(insertEmployee);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
