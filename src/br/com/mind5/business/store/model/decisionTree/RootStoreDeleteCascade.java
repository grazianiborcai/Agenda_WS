package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.LazyStoreDelete;
import br.com.mind5.business.store.model.action.LazyStoreEnforceLChanged;
import br.com.mind5.business.store.model.action.LazyStoreMergeUsername;
import br.com.mind5.business.store.model.action.LazyStoreNodeDeleteAddress;
import br.com.mind5.business.store.model.action.LazyStoreNodeDeleteComp;
import br.com.mind5.business.store.model.action.LazyStoreNodeDeleteMatore;
import br.com.mind5.business.store.model.action.LazyStoreNodeDeletePerson;
import br.com.mind5.business.store.model.action.LazyStoreNodeDeletePhone;
import br.com.mind5.business.store.model.action.LazyStoreNodeDeleteStolevate;
import br.com.mind5.business.store.model.action.LazyStoreNodeDeleteStowotm;
import br.com.mind5.business.store.model.action.LazyStoreNodeDeleteUser;
import br.com.mind5.business.store.model.action.LazyStoreUpdate;
import br.com.mind5.business.store.model.action.StdStoreMergeToDelete;
import br.com.mind5.business.store.model.checker.StoreCheckDelete;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.business.store.model.checker.StoreCheckLangu;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootStoreDeleteCascade extends DeciTreeWriteTemplate<StoreInfo> {	
	
	public RootStoreDeleteCascade(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildDecisionCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoreCheckDelete(checkerOption);
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckExist(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerQueue<StoreInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		ActionStd<StoreInfo> mergeToDelete = new StdStoreMergeToDelete(option);
		ActionLazy<StoreInfo> enforceLChanged = new LazyStoreEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<StoreInfo> enforceLChangedBy = new LazyStoreMergeUsername(option.conn, option.schemaName);
		ActionLazy<StoreInfo> update = new LazyStoreUpdate(option.conn, option.schemaName);
		ActionLazy<StoreInfo> deleteStowotm = new LazyStoreNodeDeleteStowotm(option.conn, option.schemaName);
		ActionLazy<StoreInfo> deleteStolevate = new LazyStoreNodeDeleteStolevate(option.conn, option.schemaName);
		ActionLazy<StoreInfo> deleteMatore = new LazyStoreNodeDeleteMatore(option.conn, option.schemaName);		
		ActionLazy<StoreInfo> deleteAddress = new LazyStoreNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazy<StoreInfo> deletePhone = new LazyStoreNodeDeletePhone(option.conn, option.schemaName);
		ActionLazy<StoreInfo> deletePerson = new LazyStoreNodeDeletePerson(option.conn, option.schemaName);
		ActionLazy<StoreInfo> deleteCompany = new LazyStoreNodeDeleteComp(option.conn, option.schemaName);
		ActionLazy<StoreInfo> deleteUser = new LazyStoreNodeDeleteUser(option.conn, option.schemaName);
		ActionLazy<StoreInfo> deleteStore = new LazyStoreDelete(option.conn, option.schemaName);			
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		
		update.addPostAction(deleteStowotm);
		update.addPostAction(deleteStolevate);
		update.addPostAction(deleteMatore);
		update.addPostAction(deleteAddress);
		update.addPostAction(deletePhone);
		update.addPostAction(deletePerson);
		update.addPostAction(deleteCompany);
		update.addPostAction(deleteUser);
		update.addPostAction(deleteStore);
		
		actions.add(mergeToDelete);		
		return actions;
	}
}
