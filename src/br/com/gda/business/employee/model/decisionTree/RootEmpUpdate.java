package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.action.LazyEmpEnforceEntityCateg;
import br.com.gda.business.employee.model.action.LazyEmpKeepEmp;
import br.com.gda.business.employee.model.action.LazyEmpNodeUpdatePerson;
import br.com.gda.business.employee.model.action.LazyEmpNodeUpsertAddress;
import br.com.gda.business.employee.model.action.LazyEmpNodeUpsertPhone;
import br.com.gda.business.employee.model.action.LazyEmpUpdate;
import br.com.gda.business.employee.model.action.StdEmpEnforceLChanged;
import br.com.gda.business.employee.model.checker.EmpCheckExist;
import br.com.gda.business.employee.model.checker.EmpCheckKey;
import br.com.gda.business.employee.model.checker.EmpCheckOwner;
import br.com.gda.business.employee.model.checker.EmpCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootEmpUpdate implements DeciTree<EmpInfo> {
	private DeciTree<EmpInfo> tree;
	
	
	public RootEmpUpdate(DeciTreeOption<EmpInfo> option) {
		DeciTreeHelperOption<EmpInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.schemaName = option.schemaName;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpInfo> buildDecisionChecker(DeciTreeOption<EmpInfo> option) {
		final boolean EXIST_ON_DB = true;			
		final boolean KEY_NOT_NULL = true;	
		
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new EmpCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = KEY_NOT_NULL;
		checker = new EmpCheckKey(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<EmpInfo>> buildActionsOnPassed(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();

		ActionStd<EmpInfo> enforceLChanged = new StdEmpEnforceLChanged(option);
		ActionLazy<EmpInfo> enforceEntityCateg = new LazyEmpEnforceEntityCateg(option.conn, option.schemaName);
		ActionLazy<EmpInfo> keepEmployee = new LazyEmpKeepEmp(option.conn, option.schemaName);
		ActionLazy<EmpInfo> updateEmployee = new LazyEmpUpdate(option.conn, option.schemaName);	
		ActionLazy<EmpInfo> updatePerson = new LazyEmpNodeUpdatePerson(option.conn, option.schemaName);
		ActionLazy<EmpInfo> upsertAddress = new LazyEmpNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<EmpInfo> upsertPhone = new LazyEmpNodeUpsertPhone(option.conn, option.schemaName);		
		ActionStd<EmpInfo> select = new RootEmpSelect(option).toAction();		
		
		enforceLChanged.addPostAction(enforceEntityCateg);
		enforceEntityCateg.addPostAction(keepEmployee);
		
		keepEmployee.addPostAction(updateEmployee);		
		keepEmployee.addPostAction(updatePerson);	
		keepEmployee.addPostAction(upsertAddress);		
		keepEmployee.addPostAction(upsertPhone);
		
		actions.add(enforceLChanged);
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmpInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<EmpInfo> toAction() {
		return tree.toAction();
	}
}
