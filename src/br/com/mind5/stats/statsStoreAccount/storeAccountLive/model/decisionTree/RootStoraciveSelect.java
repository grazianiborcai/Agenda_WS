package br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.action.LazyStoraciveMergeMonth;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.action.LazyStoraciveMergeState;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.action.StdStoraciveMergeToSelect;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.checker.StoraciveCheckRead;


public final class RootStoraciveSelect extends DeciTreeTemplateWrite<StoraciveInfo> {
	
	public RootStoraciveSelect(DeciTreeOption<StoraciveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoraciveInfo> buildCheckerHook(DeciTreeOption<StoraciveInfo> option) {
		List<ModelChecker<StoraciveInfo>> queue = new ArrayList<>();		
		ModelChecker<StoraciveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StoraciveCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoraciveInfo>> buildActionsOnPassedHook(DeciTreeOption<StoraciveInfo> option) {
		List<ActionStd<StoraciveInfo>> actions = new ArrayList<>();

		ActionStd<StoraciveInfo> select = new StdStoraciveMergeToSelect(option);
		ActionLazy<StoraciveInfo> mergeStore = new LazyStoraciveMergeState(option.conn, option.schemaName);
		ActionLazy<StoraciveInfo> mergeMonth = new LazyStoraciveMergeMonth(option.conn, option.schemaName);
		
		select.addPostAction(mergeStore);
		mergeStore.addPostAction(mergeMonth);
		
		actions.add(select);
		return actions;
	}
}
