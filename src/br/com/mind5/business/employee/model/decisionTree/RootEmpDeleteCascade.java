package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpDaoDelete;
import br.com.mind5.business.employee.model.action.LazyEmpPersonDelete;
import br.com.mind5.business.employee.model.action.LazyEmpEnforceLChanged;
import br.com.mind5.business.employee.model.action.LazyEmpMergeUsername;
import br.com.mind5.business.employee.model.action.LazyEmpNodeDeleteAddress;
import br.com.mind5.business.employee.model.action.LazyEmpNodeDeleteEmpmat;
import br.com.mind5.business.employee.model.action.LazyEmpNodeDeleteEmpos;
import br.com.mind5.business.employee.model.action.LazyEmpNodeDeletePhone;
import br.com.mind5.business.employee.model.action.LazyEmpNodeDeleteUser;
import br.com.mind5.business.employee.model.action.LazyEmpDaoUpdate;
import br.com.mind5.business.employee.model.action.StdEmpMergeToDelete;
import br.com.mind5.business.employee.model.checker.EmpCheckDelete;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employee.model.checker.EmpCheckLangu;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmpDeleteCascade extends DeciTreeTemplateWrite<EmpInfo> {
	
	public RootEmpDeleteCascade(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpCheckDelete(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckExist(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerHelperQueue<EmpInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		//TODO: eliminar do carrinho de compras
		ActionStd<EmpInfo> mergeToDelete = new StdEmpMergeToDelete(option);
		ActionLazy<EmpInfo> enforceLChanged = new LazyEmpEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<EmpInfo> enforceLChangedBy = new LazyEmpMergeUsername(option.conn, option.schemaName);
		ActionLazy<EmpInfo> update = new LazyEmpDaoUpdate(option.conn, option.schemaName);		
		ActionLazy<EmpInfo> deleteEmpos = new LazyEmpNodeDeleteEmpos(option.conn, option.schemaName);
		ActionLazy<EmpInfo> deleteEmpmat = new LazyEmpNodeDeleteEmpmat(option.conn, option.schemaName);
		ActionLazy<EmpInfo> deleteAddress = new LazyEmpNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazy<EmpInfo> deletePhone = new LazyEmpNodeDeletePhone(option.conn, option.schemaName);
		ActionLazy<EmpInfo> deletePerson = new LazyEmpPersonDelete(option.conn, option.schemaName);
		ActionLazy<EmpInfo> deleteUser = new LazyEmpNodeDeleteUser(option.conn, option.schemaName);
		ActionLazy<EmpInfo> deleteEmployee = new LazyEmpDaoDelete(option.conn, option.schemaName);	

		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		
		update.addPostAction(deleteEmpos);
		update.addPostAction(deleteEmpmat);
		update.addPostAction(deleteAddress);
		update.addPostAction(deletePhone);
		update.addPostAction(deletePerson);
		update.addPostAction(deleteUser);
		update.addPostAction(deleteEmployee);
		
		actions.add(mergeToDelete);		
		return actions;
	}
}
