package br.com.mind5.business.storeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapMergeCurrency;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapMergePhonap;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapMergeTimezone;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapNodeCompnap;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapNodePersonap;
import br.com.mind5.business.storeSnapshot.model.action.StdStorapMergeToSelect;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckLangu;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckOwner;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class RootStorapSelect extends DeciTreeTemplateRead<StorapInfo> {
	
	public RootStorapSelect(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorapInfo> buildCheckerHook(DeciTreeOption<StorapInfo> option) {
		List<ModelChecker<StorapInfo>> queue = new ArrayList<>();		
		ModelChecker<StorapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorapCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorapCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorapInfo>> buildActionsOnPassedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStd<StorapInfo>> actions = new ArrayList<>();

		ActionStd<StorapInfo> select = new StdStorapMergeToSelect(option);
		ActionLazy<StorapInfo> mergeCurrency = new LazyStorapMergeCurrency(option.conn, option.schemaName);
		ActionLazy<StorapInfo> mergeTimezone = new LazyStorapMergeTimezone(option.conn, option.schemaName); 
		ActionLazy<StorapInfo> mergePhonap = new LazyStorapMergePhonap(option.conn, option.schemaName);
		ActionLazy<StorapInfo> nodePersonap = new LazyStorapNodePersonap(option.conn, option.schemaName);
		ActionLazy<StorapInfo> nodeCompnap = new LazyStorapNodeCompnap(option.conn, option.schemaName);
		
		select.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeTimezone); 
		mergeTimezone.addPostAction(mergePhonap);
		mergePhonap.addPostAction(nodePersonap);
		nodePersonap.addPostAction(nodeCompnap);
		
		actions.add(select);
		return actions;
	}
}
