package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.action.LazyEmpEnforceAddressKey;
import br.com.gda.business.employee.model.action.LazyEmpEnforceEntityCateg;
import br.com.gda.business.employee.model.action.LazyEmpEnforcePersonKey;
import br.com.gda.business.employee.model.action.LazyEmpEnforcePhoneKey;
import br.com.gda.business.employee.model.action.LazyEmpInsert;
import br.com.gda.business.employee.model.action.LazyEmpInsertPerson;
import br.com.gda.business.employee.model.action.LazyEmpMergeUsername;
import br.com.gda.business.employee.model.action.LazyEmpNodeUpsertAddress;
import br.com.gda.business.employee.model.action.LazyEmpNodeUpsertPhone;
import br.com.gda.business.employee.model.action.LazyEmpRootSelect;
import br.com.gda.business.employee.model.action.LazyEmpUpdate;
import br.com.gda.business.employee.model.action.StdEmpEnforceLChanged;
import br.com.gda.business.employee.model.checker.EmpCheckGenField;
import br.com.gda.business.employee.model.checker.EmpCheckLangu;
import br.com.gda.business.employee.model.checker.EmpCheckOwner;
import br.com.gda.business.employee.model.checker.EmpCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmpInsert extends DeciTreeWriteTemplate<EmpInfo> {	
	
	public RootEmpInsert(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildDecisionCheckerHook(DeciTreeOption<EmpInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new EmpCheckWrite();
		queue.add(checker);
		
		checker = new EmpCheckGenField();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpInfo> enforceLChanged = new StdEmpEnforceLChanged(option);
		ActionLazy<EmpInfo> enforceLChangedBy = new LazyEmpMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmpInfo> insertEmployee = new LazyEmpInsert(option.conn, option.schemaName);
		ActionLazy<EmpInfo> enforceEntityCateg = new LazyEmpEnforceEntityCateg(option.conn, option.schemaName);
		ActionLazy<EmpInfo> enforcePersonKey = new LazyEmpEnforcePersonKey(option.conn, option.schemaName);
		ActionLazy<EmpInfo> insertPerson = new LazyEmpInsertPerson(option.conn, option.schemaName);	
		ActionLazy<EmpInfo> updateEmployee = new LazyEmpUpdate(option.conn, option.schemaName);	
		ActionLazy<EmpInfo> enforceAddressKey = new LazyEmpEnforceAddressKey(option.conn, option.schemaName);
		ActionLazy<EmpInfo> upsertAddress = new LazyEmpNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<EmpInfo> enforcePhoneKey = new LazyEmpEnforcePhoneKey(option.conn, option.schemaName);
		ActionLazy<EmpInfo> upsertPhone = new LazyEmpNodeUpsertPhone(option.conn, option.schemaName);		
		ActionLazy<EmpInfo> select = new LazyEmpRootSelect(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(insertEmployee);
		insertEmployee.addPostAction(enforceEntityCateg);
		enforceEntityCateg.addPostAction(enforcePersonKey);
		enforcePersonKey.addPostAction(insertPerson);		
		insertPerson.addPostAction(updateEmployee);
		
		updateEmployee.addPostAction(enforceAddressKey);
		enforceAddressKey.addPostAction(upsertAddress);
		
		updateEmployee.addPostAction(enforcePhoneKey);
		enforcePhoneKey.addPostAction(upsertPhone);	
		
		updateEmployee.addPostAction(select);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
