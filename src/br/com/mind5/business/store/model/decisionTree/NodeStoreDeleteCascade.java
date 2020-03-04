package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StdStoreDelete;
import br.com.mind5.business.store.model.checker.StoreCheckDummy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeStoreDeleteCascade extends DeciTreeWriteTemplate<StoreInfo> {	
	
	public NodeStoreDeleteCascade(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildDecisionCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;

		checker = new StoreCheckDummy();
		queue.add(checker);
		
		 return new ModelCheckerQueue<StoreInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		ActionStd<StoreInfo> deleteStowotm = new NodeStoreDeleteStowotm(option).toAction();
		ActionStd<StoreInfo> deleteStolate = new NodeStoreDeleteStolate(option).toAction();
		ActionStd<StoreInfo> deleteMatore = new NodeStoreDeleteMatore(option).toAction();
		ActionStd<StoreInfo> deleteAddress = new NodeStoreDeleteAddress(option).toAction();
		ActionStd<StoreInfo> deletePhone = new NodeStoreDeletePhone(option).toAction();
		ActionStd<StoreInfo> deletePerson = new NodeStoreDeletePerson(option).toAction();
		ActionStd<StoreInfo> deleteCompany = new NodeStoreDeleteComp(option).toAction();
		ActionStd<StoreInfo> deleteUser = new NodeStoreDeleteUser(option).toAction();
		ActionStd<StoreInfo> deleteStore = new StdStoreDelete(option);

		actions.add(deleteStowotm);		
		actions.add(deleteStolate);			
		actions.add(deleteMatore);	
		actions.add(deleteAddress);	
		actions.add(deletePhone);	
		actions.add(deletePerson);	
		actions.add(deleteCompany);	
		actions.add(deleteUser);	
		actions.add(deleteStore);			
		
		return actions;
	}
}
