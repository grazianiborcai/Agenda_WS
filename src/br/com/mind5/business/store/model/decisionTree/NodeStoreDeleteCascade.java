package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StdStoreDaoDelete;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeStoreDeleteCascade extends DeciTreeTemplateWriteV2<StoreInfo> {	
	
	public NodeStoreDeleteCascade(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoreInfo> buildCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelCheckerV1<StoreInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoreInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		 return new ModelCheckerHelperQueueV2<StoreInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStdV2<StoreInfo>> actions = new ArrayList<>();
		
		ActionStdV2<StoreInfo> deleteStowotm = new NodeStoreDeleteStowotm(option).toAction();
		ActionStdV2<StoreInfo> deleteStolate = new NodeStoreDeleteStolate(option).toAction();
		ActionStdV2<StoreInfo> deleteMatore = new NodeStoreDeleteMatore(option).toAction();
		ActionStdV2<StoreInfo> deleteAddress = new NodeStoreDeleteAddress(option).toAction();
		ActionStdV2<StoreInfo> deletePhone = new NodeStoreDeletePhone(option).toAction();
		ActionStdV2<StoreInfo> deletePerson = new NodeStoreDeletePerson(option).toAction();
		ActionStdV2<StoreInfo> deleteCompany = new NodeStoreDeleteComp(option).toAction();
		ActionStdV2<StoreInfo> deleteUser = new NodeStoreDeleteUser(option).toAction();
		ActionStdV2<StoreInfo> deleteStore = new StdStoreDaoDelete(option);

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
