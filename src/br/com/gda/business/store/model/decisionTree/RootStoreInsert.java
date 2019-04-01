package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.action.LazyStoreInsert;
import br.com.gda.business.store.model.action.LazyStoreMergeUsername;
import br.com.gda.business.store.model.action.LazyStoreNodeInsertComp;
import br.com.gda.business.store.model.action.LazyStoreNodeInsertPerson;
import br.com.gda.business.store.model.action.LazyStoreNodeInsertUser;
import br.com.gda.business.store.model.action.LazyStoreNodeUpsertAddress;
import br.com.gda.business.store.model.action.LazyStoreNodeUpsertPhone;
import br.com.gda.business.store.model.action.LazyStoreRootSelect;
import br.com.gda.business.store.model.action.LazyStoreUpdate;
import br.com.gda.business.store.model.action.StdStoreEnforceLChanged;
import br.com.gda.business.store.model.checker.StoreCheckCurrency;
import br.com.gda.business.store.model.checker.StoreCheckTechField;
import br.com.gda.business.store.model.checker.StoreCheckLangu;
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
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootStoreInsert extends DeciTreeWriteTemplate<StoreInfo> {
	
	public RootStoreInsert(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildDecisionCheckerHook(DeciTreeOption<StoreInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new StoreCheckWrite();
		queue.add(checker);
		
		checker = new StoreCheckTechField();
		queue.add(checker);
		
		checker = new StoreCheckWritePhone();
		queue.add(checker);
		
		checker = new StoreCheckWriteAddress();
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
		checker = new StoreCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreCheckTimezone(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreCheckCurrency(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		//TODO: permitir que outro usuario seja associado ou inves de sempre criar um novo ?
		ActionStd<StoreInfo> enforceLChanged = new StdStoreEnforceLChanged(option);
		ActionLazy<StoreInfo> enforceLChangedBy = new LazyStoreMergeUsername(option.conn, option.schemaName);
		ActionLazy<StoreInfo> insertStore = new LazyStoreInsert(option.conn, option.schemaName);
		ActionLazy<StoreInfo> insertPerson = new LazyStoreNodeInsertPerson(option.conn, option.schemaName);	
		ActionLazy<StoreInfo> insertComp = new LazyStoreNodeInsertComp(option.conn, option.schemaName);
		ActionLazy<StoreInfo> insertUser = new LazyStoreNodeInsertUser(option.conn, option.schemaName);	
		ActionLazy<StoreInfo> updateStore = new LazyStoreUpdate(option.conn, option.schemaName);
		ActionLazy<StoreInfo> upsertAddress = new LazyStoreNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<StoreInfo> upsertPhone = new LazyStoreNodeUpsertPhone(option.conn, option.schemaName);		
		ActionLazy<StoreInfo> selectStore = new LazyStoreRootSelect(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(insertStore);
		insertStore.addPostAction(insertPerson);		
		insertPerson.addPostAction(insertComp);		
		insertComp.addPostAction(insertUser);
		insertUser.addPostAction(updateStore);		
		insertUser.addPostAction(upsertAddress);		
		insertUser.addPostAction(upsertPhone);			
		insertUser.addPostAction(selectStore);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
