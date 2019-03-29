package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.action.LazyStoreDelete;
import br.com.gda.business.store.model.action.LazyStoreEnforceLChanged;
import br.com.gda.business.store.model.action.LazyStoreMergeUsername;
import br.com.gda.business.store.model.action.LazyStoreNodeDeleteAddress;
import br.com.gda.business.store.model.action.LazyStoreNodeDeleteComp;
import br.com.gda.business.store.model.action.LazyStoreNodeDeleteMatore;
import br.com.gda.business.store.model.action.LazyStoreNodeDeletePerson;
import br.com.gda.business.store.model.action.LazyStoreNodeDeletePhone;
import br.com.gda.business.store.model.action.LazyStoreNodeDeleteStolevate;
import br.com.gda.business.store.model.action.LazyStoreNodeDeleteStowotm;
import br.com.gda.business.store.model.action.LazyStoreNodeDeleteUser;
import br.com.gda.business.store.model.action.LazyStoreUpdate;
import br.com.gda.business.store.model.action.StdStoreMergeToDelete;
import br.com.gda.business.store.model.checker.StoreCheckDelete;
import br.com.gda.business.store.model.checker.StoreCheckExist;
import br.com.gda.business.store.model.checker.StoreCheckLangu;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootStoreDelete implements DeciTree<StoreInfo> {
	private DeciTree<StoreInfo> tree;
	
	
	public RootStoreDelete(DeciTreeOption<StoreInfo> option) {
		DeciTreeHelperOption<StoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);		
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreInfo> buildDecisionChecker(DeciTreeOption<StoreInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new StoreCheckDelete();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreCheckExist(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerQueue<StoreInfo>(queue);
	}
	
	
	
	private List<ActionStd<StoreInfo>> buildActionsOnPassed(DeciTreeOption<StoreInfo> option) {
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
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<StoreInfo> toAction() {
		return tree.toAction();
	}
}
