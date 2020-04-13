package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StdStoreDelete;
import br.com.mind5.business.store.model.checker.StoreCheckDummy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class NodeStoreDeleteCascade extends DeciTreeTemplateWriteV1<StoreInfo> {	
	
	public NodeStoreDeleteCascade(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoreInfo> buildCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelCheckerV1<StoreInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoreInfo> checker;

		checker = new StoreCheckDummy();
		queue.add(checker);
		
		 return new ModelCheckerHelperQueueV2<StoreInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStdV1<StoreInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoreInfo> deleteStowotm = new NodeStoreDeleteStowotm(option).toAction();
		ActionStdV1<StoreInfo> deleteStolate = new NodeStoreDeleteStolate(option).toAction();
		ActionStdV1<StoreInfo> deleteMatore = new NodeStoreDeleteMatore(option).toAction();
		ActionStdV1<StoreInfo> deleteAddress = new NodeStoreDeleteAddress(option).toAction();
		ActionStdV1<StoreInfo> deletePhone = new NodeStoreDeletePhone(option).toAction();
		ActionStdV1<StoreInfo> deletePerson = new NodeStoreDeletePerson(option).toAction();
		ActionStdV1<StoreInfo> deleteCompany = new NodeStoreDeleteComp(option).toAction();
		ActionStdV1<StoreInfo> deleteUser = new NodeStoreDeleteUser(option).toAction();
		ActionStdV1<StoreInfo> deleteStore = new StdStoreDelete(option);

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
