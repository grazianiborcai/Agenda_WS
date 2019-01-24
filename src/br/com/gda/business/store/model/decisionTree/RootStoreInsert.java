package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.action.StdStoreInsert;
import br.com.gda.business.store.model.action.LazyStoreEnforceEntityCateg;
import br.com.gda.business.store.model.action.LazyStoreInsert;
import br.com.gda.business.store.model.action.LazyStoreSelect;
import br.com.gda.business.store.model.action.StdStoreEnforceLChanged;
import br.com.gda.business.store.model.checker.StoreCheckGenField;
import br.com.gda.business.store.model.checker.StoreCheckOwner;
import br.com.gda.business.store.model.checker.StoreCheckTimezone;
import br.com.gda.business.store.model.checker.StoreCheckWrite;
import br.com.gda.business.store.model.checker.StoreCheckWriteAddress;
import br.com.gda.business.store.model.checker.StoreCheckWritePhone;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootStoreInsert implements DeciTree<StoreInfo> {
	private DeciTree<StoreInfo> tree;
	
	
	public RootStoreInsert(DeciTreeOption<StoreInfo> option) {
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
		
		checker = new StoreCheckWrite();
		queue.add(checker);
		
		checker = new StoreCheckGenField();
		queue.add(checker);
		
		checker = new StoreCheckWritePhone();
		queue.add(checker);
		
		checker = new StoreCheckWriteAddress();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreCheckTimezone(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<StoreInfo>> buildActionsOnPassed(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		ActionStd<StoreInfo> enforceLChanged = new StdStoreEnforceLChanged(option);
		ActionLazy<StoreInfo> insertStore = new LazyStoreInsert(option.conn, option.schemaName);
		ActionLazy<StoreInfo> enforceEntityCateg = new LazyStoreEnforceEntityCateg(option.conn, option.schemaName);
		ActionLazy<StoreInfo> enforcePersonKey = new LazyOwnerEnforcePersonKey(option.conn, option.schemaName);
		ActionLazy<StoreInfo> insertPerson = new LazyOwnerInsertPerson(option.conn, option.schemaName);	
		ActionLazy<StoreInfo> enforceCompKey = new LazyOwnerEnforceCompKey(option.conn, option.schemaName);
		ActionLazy<StoreInfo> insertComp = new LazyOwnerInsertComp(option.conn, option.schemaName);
		ActionLazy<StoreInfo> updateOwner = new LazyOwnerUpdate(option.conn, option.schemaName);	
		ActionLazy<StoreInfo> enforceAddressKey = new LazyOwnerEnforceAddressKey(option.conn, option.schemaName);
		ActionLazy<StoreInfo> upsertAddress = new LazyOwnerNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<StoreInfo> enforcePhoneKey = new LazyOwnerEnforcePhoneKey(option.conn, option.schemaName);
		ActionLazy<StoreInfo> upsertPhone = new LazyOwnerNodeUpsertPhone(option.conn, option.schemaName);		
		ActionLazy<StoreInfo> selectOwner = new LazyOwnerRootSelect(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(insertStore);
		insertStore.addPostAction(enforceEntityCateg);
		enforceEntityCateg.addPostAction(enforcePersonKey);
		enforcePersonKey.addPostAction(insertPerson);
		
		insertPerson.addPostAction(enforceCompKey);
		enforceCompKey.addPostAction(insertComp);		
		insertComp.addPostAction(updateOwner);
		
		updateOwner.addPostAction(enforceAddressKey);
		enforceAddressKey.addPostAction(upsertAddress);
		
		updateOwner.addPostAction(enforcePhoneKey);
		enforcePhoneKey.addPostAction(upsertPhone);	
		
		updateOwner.addPostAction(selectOwner);
		
		actions.add(enforceLChanged);	
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
