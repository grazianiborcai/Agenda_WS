package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StoreVisiDaoDelete;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StoreNodeDeleteCascade extends DeciTreeTemplateWrite<StoreInfo> {	
	
	public StoreNodeDeleteCascade(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		 return new ModelCheckerHelperQueue<StoreInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		ActionStd<StoreInfo> deleteStowotm = new StoreNodeStowotmDelete(option).toAction();
		ActionStd<StoreInfo> deleteStuntm = new StoreNodeStuntmDelete(option).toAction();
		ActionStd<StoreInfo> deleteStolate = new StoreNodeStolateDelete(option).toAction();
		ActionStd<StoreInfo> deleteMatore = new StoreNodeMatoreDelete(option).toAction();
		ActionStd<StoreInfo> deleteAddress = new StoreNodeAddressDelete(option).toAction();
		ActionStd<StoreInfo> deletePhone = new StoreNodePhoneDelete(option).toAction();
		ActionStd<StoreInfo> deletePereg = new StoreNodePeregDelete(option).toAction();
		ActionStd<StoreInfo> deleteCompany = new StoreNodeCompDelete(option).toAction();
		ActionStd<StoreInfo> deleteUser = new StoreNodeUserDelete(option).toAction();
		ActionStd<StoreInfo> deleteStore = new ActionStdCommom<StoreInfo>(option, StoreVisiDaoDelete.class);

		actions.add(deleteStowotm);
		actions.add(deleteStuntm);
		actions.add(deleteStolate);			
		actions.add(deleteMatore);	
		actions.add(deleteAddress);	
		actions.add(deletePhone);	
		actions.add(deletePereg);	
		actions.add(deleteCompany);	
		actions.add(deleteUser);	
		actions.add(deleteStore);			
		
		return actions;
	}
}
