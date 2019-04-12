package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.action.LazyEmpDelete;
import br.com.gda.business.employee.model.action.LazyEmpNodeDeleteEmpos;
import br.com.gda.business.employee.model.action.LazyEmpDeletePerson;
import br.com.gda.business.employee.model.action.LazyEmpEnforceLChanged;
import br.com.gda.business.employee.model.action.LazyEmpMergeUsername;
import br.com.gda.business.employee.model.action.LazyEmpNodeDeleteAddress;
import br.com.gda.business.employee.model.action.LazyEmpNodeDeletePhone;
import br.com.gda.business.employee.model.action.LazyEmpNodeDeleteUser;
import br.com.gda.business.employee.model.action.LazyEmpUpdate;
import br.com.gda.business.employee.model.action.StdEmpMergeToDelete;
import br.com.gda.business.employee.model.checker.EmpCheckDelete;
import br.com.gda.business.employee.model.checker.EmpCheckExist;
import br.com.gda.business.employee.model.checker.EmpCheckLangu;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootEmpDelete extends DeciTreeWriteTemplate<EmpInfo> {
	
	public RootEmpDelete(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildDecisionCheckerHook(DeciTreeOption<EmpInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new EmpCheckDelete();
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
		checker = new EmpCheckExist(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerQueue<EmpInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpInfo> mergeToDelete = new StdEmpMergeToDelete(option);
		ActionLazy<EmpInfo> enforceLChanged = new LazyEmpEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<EmpInfo> enforceLChangedBy = new LazyEmpMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmpInfo> update = new LazyEmpUpdate(option.conn, option.schemaName);		
		ActionLazy<EmpInfo> deleteAddress = new LazyEmpNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazy<EmpInfo> deletePhone = new LazyEmpNodeDeletePhone(option.conn, option.schemaName);
		ActionLazy<EmpInfo> deletePerson = new LazyEmpDeletePerson(option.conn, option.schemaName);
		ActionLazy<EmpInfo> deleteUser = new LazyEmpNodeDeleteUser(option.conn, option.schemaName);
		ActionLazy<EmpInfo> deleteEmpos = new LazyEmpNodeDeleteEmpos(option.conn, option.schemaName);
		ActionLazy<EmpInfo> deleteEmployee = new LazyEmpDelete(option.conn, option.schemaName);	

		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		
		update.addPostAction(deleteAddress);
		update.addPostAction(deletePhone);
		update.addPostAction(deletePerson);
		update.addPostAction(deleteUser);
		update.addPostAction(deleteEmpos);
		update.addPostAction(deleteEmployee);
		
		actions.add(mergeToDelete);		
		return actions;
	}
}
