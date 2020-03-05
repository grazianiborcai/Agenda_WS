package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.LazyStoreMergeAddress;
import br.com.mind5.business.store.model.action.LazyStoreMergeComp;
import br.com.mind5.business.store.model.action.LazyStoreMergeCurrency;
import br.com.mind5.business.store.model.action.LazyStoreMergeFimist;
import br.com.mind5.business.store.model.action.LazyStoreMergePerson;
import br.com.mind5.business.store.model.action.LazyStoreMergePhone;
import br.com.mind5.business.store.model.action.LazyStoreMergeTimezone;
import br.com.mind5.business.store.model.action.LazyStoreMergeUser;
import br.com.mind5.business.store.model.action.StdStoreMergeToSelect;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.business.store.model.checker.StoreCheckLangu;
import br.com.mind5.business.store.model.checker.StoreCheckRead;
import br.com.mind5.business.store.model.checker.StoreCheckStorauth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;


public final class RootStoreSelect extends DeciTreeReadTemplate<StoreInfo> {
	
	public RootStoreSelect(DeciTreeOption<StoreInfo> option) {
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
		checker = new StoreCheckRead(checkerOption);
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
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckStorauth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();

		ActionStd<StoreInfo> select = new StdStoreMergeToSelect(option);
		ActionLazy<StoreInfo> mergeCurrency = new LazyStoreMergeCurrency(option.conn, option.schemaName);
		ActionLazy<StoreInfo> mergeTimezone = new LazyStoreMergeTimezone(option.conn, option.schemaName);
		ActionLazy<StoreInfo> mergePerson = new LazyStoreMergePerson(option.conn, option.schemaName);
		ActionLazy<StoreInfo> mergeComp = new LazyStoreMergeComp(option.conn, option.schemaName);
		ActionLazy<StoreInfo> mergeAddress = new LazyStoreMergeAddress(option.conn, option.schemaName);
		ActionLazy<StoreInfo> mergePhone = new LazyStoreMergePhone(option.conn, option.schemaName);
		ActionLazy<StoreInfo> mergeUser = new LazyStoreMergeUser(option.conn, option.schemaName);
		ActionLazy<StoreInfo> mergeFimist = new LazyStoreMergeFimist(option.conn, option.schemaName);
		
		select.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeTimezone);
		mergeTimezone.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeComp);
		mergeComp.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeUser);
		mergeUser.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
