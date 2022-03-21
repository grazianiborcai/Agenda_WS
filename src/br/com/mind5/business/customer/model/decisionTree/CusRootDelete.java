package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.CusVisiNodeAddressDelete;
import br.com.mind5.business.customer.model.action.CusVisiNodePhoneDelete;
import br.com.mind5.business.customer.model.action.CusVisiNodeSytotauh;
import br.com.mind5.business.customer.model.action.CusVisiDaoDelete;
import br.com.mind5.business.customer.model.action.CusVisiDaoUpdate;
import br.com.mind5.business.customer.model.action.CusVisiEnforceLChanged;
import br.com.mind5.business.customer.model.action.CusVisiMergeToDelete;
import br.com.mind5.business.customer.model.action.CusVisiMergeUsername;
import br.com.mind5.business.customer.model.action.CusVisiPersonDelete;
import br.com.mind5.business.customer.model.checker.CusCheckDelete;
import br.com.mind5.business.customer.model.checker.CusCheckExist;
import br.com.mind5.business.customer.model.checker.CusCheckLangu;
import br.com.mind5.business.customer.model.checker.CusCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CusRootDelete extends DeciTreeTemplateWrite<CusInfo> {
	
	public CusRootDelete(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckExist(checkerOption);
		queue.add(checker);		
		
		 return new ModelCheckerHelperQueue<CusInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> mergeToDelete = new ActionStdCommom<CusInfo>(option, CusVisiMergeToDelete.class);
		ActionLazy<CusInfo> nodeSytotauh = new ActionLazyCommom<CusInfo>(option, CusVisiNodeSytotauh.class);
		ActionLazy<CusInfo> enforceLChanged = new ActionLazyCommom<CusInfo>(option, CusVisiEnforceLChanged.class);
		ActionLazy<CusInfo> enforceLChangedBy = new ActionLazyCommom<CusInfo>(option, CusVisiMergeUsername.class);
		ActionLazy<CusInfo> update = new ActionLazyCommom<CusInfo>(option, CusVisiDaoUpdate.class);
		ActionLazy<CusInfo> deleteAddress = new ActionLazyCommom<CusInfo>(option, CusVisiNodeAddressDelete.class);
		ActionLazy<CusInfo> deletePhone = new ActionLazyCommom<CusInfo>(option, CusVisiNodePhoneDelete.class);
		ActionLazy<CusInfo> deletePerson = new ActionLazyCommom<CusInfo>(option, CusVisiPersonDelete.class);
		ActionLazy<CusInfo> deleteCustomer = new ActionLazyCommom<CusInfo>(option, CusVisiDaoDelete.class);	
		
		mergeToDelete.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		
		update.addPostAction(deleteAddress);
		update.addPostAction(deletePhone);
		update.addPostAction(deletePerson);
		update.addPostAction(deleteCustomer);
		
		actions.add(mergeToDelete);		
		return actions;
	}
}
