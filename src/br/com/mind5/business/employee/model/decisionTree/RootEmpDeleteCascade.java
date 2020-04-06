package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.LazyEmpDelete;
import br.com.mind5.business.employee.model.action.LazyEmpDeletePerson;
import br.com.mind5.business.employee.model.action.LazyEmpEnforceLChanged;
import br.com.mind5.business.employee.model.action.LazyEmpMergeUsername;
import br.com.mind5.business.employee.model.action.LazyEmpNodeDeleteAddress;
import br.com.mind5.business.employee.model.action.LazyEmpNodeDeleteEmpmat;
import br.com.mind5.business.employee.model.action.LazyEmpNodeDeleteEmpos;
import br.com.mind5.business.employee.model.action.LazyEmpNodeDeletePhone;
import br.com.mind5.business.employee.model.action.LazyEmpNodeDeleteUser;
import br.com.mind5.business.employee.model.action.LazyEmpUpdate;
import br.com.mind5.business.employee.model.action.StdEmpMergeToDelete;
import br.com.mind5.business.employee.model.checker.EmpCheckDelete;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employee.model.checker.EmpCheckLangu;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootEmpDeleteCascade extends DeciTreeTemplateWrite<EmpInfo> {
	
	public RootEmpDeleteCascade(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {
		List<ModelCheckerV1<EmpInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<EmpInfo> checker;
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
		
		 return new ModelCheckerHelperQueueV2<EmpInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStdV1<EmpInfo>> actions = new ArrayList<>();
		//TODO: eliminar do carrinho de compras
		ActionStdV1<EmpInfo> mergeToDelete = new StdEmpMergeToDelete(option);
		ActionLazyV1<EmpInfo> enforceLChanged = new LazyEmpEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<EmpInfo> enforceLChangedBy = new LazyEmpMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<EmpInfo> update = new LazyEmpUpdate(option.conn, option.schemaName);		
		ActionLazyV1<EmpInfo> deleteEmpos = new LazyEmpNodeDeleteEmpos(option.conn, option.schemaName);
		ActionLazyV1<EmpInfo> deleteEmpmat = new LazyEmpNodeDeleteEmpmat(option.conn, option.schemaName);
		ActionLazyV1<EmpInfo> deleteAddress = new LazyEmpNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazyV1<EmpInfo> deletePhone = new LazyEmpNodeDeletePhone(option.conn, option.schemaName);
		ActionLazyV1<EmpInfo> deletePerson = new LazyEmpDeletePerson(option.conn, option.schemaName);
		ActionLazyV1<EmpInfo> deleteUser = new LazyEmpNodeDeleteUser(option.conn, option.schemaName);
		ActionLazyV1<EmpInfo> deleteEmployee = new LazyEmpDelete(option.conn, option.schemaName);	

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
