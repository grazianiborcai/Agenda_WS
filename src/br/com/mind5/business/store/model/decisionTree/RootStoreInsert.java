package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.LazyStoreMatbcinInsert;
import br.com.mind5.business.store.model.action.LazyStoreNodeInsertComp;
import br.com.mind5.business.store.model.action.LazyStoreNodeInsertPerson;
import br.com.mind5.business.store.model.action.LazyStoreNodeInsertPhone;
import br.com.mind5.business.store.model.action.LazyStoreNodeInsertStorext;
import br.com.mind5.business.store.model.action.LazyStoreNodeSnapshot;
import br.com.mind5.business.store.model.action.LazyStoreNodeUpsertAddress;
import br.com.mind5.business.store.model.action.LazyStoreRootSelect;
import br.com.mind5.business.store.model.action.LazyStoreUserInsert;
import br.com.mind5.business.store.model.checker.StoreCheckCurrency;
import br.com.mind5.business.store.model.checker.StoreCheckHasAddress;
import br.com.mind5.business.store.model.checker.StoreCheckLangu;
import br.com.mind5.business.store.model.checker.StoreCheckOwner;
import br.com.mind5.business.store.model.checker.StoreCheckTimezone;
import br.com.mind5.business.store.model.checker.StoreCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootStoreInsert extends DeciTreeTemplateWriteV2<StoreInfo> {
	
	public RootStoreInsert(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoreInfo> buildCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelCheckerV1<StoreInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoreInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoreCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StoreCheckHasAddress(checkerOption);
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
		checker = new StoreCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckTimezone(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckCurrency(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStdV1<StoreInfo>> actions = new ArrayList<>();
		//TODO: permitir que outro usuario seja associado ou inves de sempre criar um novo ?
		//TODO: O que fazer se o CPF/e-mail ja tiver associado a um customer/owner/store manager ?
		ActionStdV1<StoreInfo> insertStore = new NodeStoreInsert(option).toAction();
		ActionLazy<StoreInfo> insertPerson = new LazyStoreNodeInsertPerson(option.conn, option.schemaName);	
		ActionLazy<StoreInfo> insertComp = new LazyStoreNodeInsertComp(option.conn, option.schemaName);
		ActionLazy<StoreInfo> insertUser = new LazyStoreUserInsert(option.conn, option.schemaName);
		ActionLazy<StoreInfo> snapshot = new LazyStoreNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<StoreInfo> upsertAddress = new LazyStoreNodeUpsertAddress(option.conn, option.schemaName);		
		ActionLazy<StoreInfo> insertPhone = new LazyStoreNodeInsertPhone(option.conn, option.schemaName);
		ActionLazy<StoreInfo> insertStorext = new LazyStoreNodeInsertStorext(option.conn, option.schemaName);			
		ActionLazy<StoreInfo> matbcinInsert = new LazyStoreMatbcinInsert(option.conn, option.schemaName);		
		ActionLazy<StoreInfo> selectStore = new LazyStoreRootSelect(option.conn, option.schemaName);	
		
		insertStore.addPostAction(insertPerson);		
		insertPerson.addPostAction(insertComp);		
		insertComp.addPostAction(insertUser);
		insertUser.addPostAction(snapshot);
		snapshot.addPostAction(upsertAddress);			
		snapshot.addPostAction(insertPhone);
		snapshot.addPostAction(insertStorext);
		snapshot.addPostAction(matbcinInsert);
		snapshot.addPostAction(selectStore);
		
		actions.add(insertStore);	
		return actions;
	}
}
