package br.com.gda.business.storeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.business.storeSnapshot.model.action.LazyStorapMergeAddresnap;
import br.com.gda.business.storeSnapshot.model.action.LazyStorapMergeCurrency;
import br.com.gda.business.storeSnapshot.model.action.LazyStorapMergePhonap;
import br.com.gda.business.storeSnapshot.model.action.LazyStorapMergeTimezone;
import br.com.gda.business.storeSnapshot.model.action.LazyStorapNodePersonap;
import br.com.gda.business.storeSnapshot.model.action.LazyStorapNodeUserap;
import br.com.gda.business.storeSnapshot.model.action.StdStorapMergeToSelect;
import br.com.gda.business.storeSnapshot.model.checker.StorapCheckLangu;
import br.com.gda.business.storeSnapshot.model.checker.StorapCheckRead;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;


public final class RootStorapSelect extends DeciTreeReadTemplate<StorapInfo> {
	
	public RootStorapSelect(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorapInfo> buildDecisionCheckerHook(DeciTreeOption<StorapInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<StorapInfo>> queue = new ArrayList<>();		
		ModelChecker<StorapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new StorapCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StorapCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorapInfo>> buildActionsOnPassedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStd<StorapInfo>> actions = new ArrayList<>();
		//TODO: mergeComp
		ActionStd<StorapInfo> select = new StdStorapMergeToSelect(option);
		ActionLazy<StorapInfo> mergeCurrency = new LazyStorapMergeCurrency(option.conn, option.schemaName);
		ActionLazy<StorapInfo> mergeTimezone = new LazyStorapMergeTimezone(option.conn, option.schemaName); 
		ActionLazy<StorapInfo> mergeAddresnap = new LazyStorapMergeAddresnap(option.conn, option.schemaName);
		ActionLazy<StorapInfo> mergePhonap = new LazyStorapMergePhonap(option.conn, option.schemaName);
		ActionLazy<StorapInfo> nodeUserap = new LazyStorapNodeUserap(option.conn, option.schemaName);
		ActionLazy<StorapInfo> nodePersonap = new LazyStorapNodePersonap(option.conn, option.schemaName);
		
		select.addPostAction(mergeCurrency);
		mergeCurrency.addPostAction(mergeTimezone); 
		mergeTimezone.addPostAction(mergeAddresnap);
		mergeAddresnap.addPostAction(mergePhonap);
		mergePhonap.addPostAction(nodeUserap);
		nodeUserap.addPostAction(nodePersonap);
		
		actions.add(select);
		return actions;
	}
}
