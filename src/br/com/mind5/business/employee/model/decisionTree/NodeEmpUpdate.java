package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpEnforceEntityCateg;
import br.com.mind5.business.employee.model.action.LazyEmpKeepEmp;
import br.com.mind5.business.employee.model.action.LazyEmpMergeUsername;
import br.com.mind5.business.employee.model.action.LazyEmpUpdate;
import br.com.mind5.business.employee.model.action.StdEmpEnforceLChanged;
import br.com.mind5.business.employee.model.checker.EmpCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeEmpUpdate extends DeciTreeWriteTemplate<EmpInfo> {
	
	public NodeEmpUpdate(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildDecisionCheckerHook(DeciTreeOption<EmpInfo> option) {		
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;		
		
		checker = new EmpCheckWrite();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();

		ActionStd<EmpInfo> enforceLChanged = new StdEmpEnforceLChanged(option);
		ActionLazy<EmpInfo> enforceLChangedBy = new LazyEmpMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmpInfo> enforceEntityCateg = new LazyEmpEnforceEntityCateg(option.conn, option.schemaName);
		ActionLazy<EmpInfo> keepEmployee = new LazyEmpKeepEmp(option.conn, option.schemaName);
		ActionLazy<EmpInfo> updateEmployee = new LazyEmpUpdate(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceEntityCateg);
		enforceEntityCateg.addPostAction(keepEmployee);
		keepEmployee.addPostAction(updateEmployee);	
		
		actions.add(enforceLChanged);
		return actions;
	}
}
