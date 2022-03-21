package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.EmpVisiNodeAddressDelete;
import br.com.mind5.business.employee.model.action.EmpVisiNodeEmpmatDelete;
import br.com.mind5.business.employee.model.action.EmpVisiNodeEmposDelete;
import br.com.mind5.business.employee.model.action.EmpVisiNodePhoneDelete;
import br.com.mind5.business.employee.model.action.EmpVisiNodeUserDelete;
import br.com.mind5.business.employee.model.action.EmpVisiDaoDelete;
import br.com.mind5.business.employee.model.action.EmpVisiDaoUpdate;
import br.com.mind5.business.employee.model.action.EmpVisiEnforceLChanged;
import br.com.mind5.business.employee.model.action.EmpVisiMergeToDelete;
import br.com.mind5.business.employee.model.action.EmpVisiMergeUsername;
import br.com.mind5.business.employee.model.action.EmpVisiPersonDelete;
import br.com.mind5.business.employee.model.checker.EmpCheckDelete;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employee.model.checker.EmpCheckLangu;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class EmpRootDeleteCascade extends DeciTreeTemplateWrite<EmpInfo> {
	
	public EmpRootDeleteCascade(DeciTreeOption<EmpInfo> option) {
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
		ActionStd<EmpInfo> mergeToDelete = new ActionStdCommom<EmpInfo>(option, EmpVisiMergeToDelete.class);
		ActionLazy<EmpInfo> enforceLChanged = new ActionLazyCommom<EmpInfo>(option, EmpVisiEnforceLChanged.class);
		ActionLazy<EmpInfo> enforceLChangedBy = new ActionLazyCommom<EmpInfo>(option, EmpVisiMergeUsername.class);
		ActionLazy<EmpInfo> update = new ActionLazyCommom<EmpInfo>(option, EmpVisiDaoUpdate.class);		
		ActionLazy<EmpInfo> deleteEmpos = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeEmposDelete.class);
		ActionLazy<EmpInfo> deleteEmpmat = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeEmpmatDelete.class);
		ActionLazy<EmpInfo> deleteAddress = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeAddressDelete.class);
		ActionLazy<EmpInfo> deletePhone = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodePhoneDelete.class);
		ActionLazy<EmpInfo> deletePerson = new ActionLazyCommom<EmpInfo>(option, EmpVisiPersonDelete.class);
		ActionLazy<EmpInfo> deleteUser = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeUserDelete.class);
		ActionLazy<EmpInfo> deleteEmployee = new ActionLazyCommom<EmpInfo>(option, EmpVisiDaoDelete.class);	

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
