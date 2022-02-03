package br.com.mind5.stats.statsStoreAccount.storeAccount.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccount.model.action.LazyStoracNodeSelectLtm;
import br.com.mind5.stats.statsStoreAccount.storeAccount.model.action.LazyStoracNodeZerofy;
import br.com.mind5.stats.statsStoreAccount.storeAccount.model.action.StdStoracMergeCalonthLtm;


public final class RootStoracSelectLtm extends DeciTreeTemplateWrite<StoracInfo> {
	
	public RootStoracSelectLtm(DeciTreeOption<StoracInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoracInfo> buildCheckerHook(DeciTreeOption<StoracInfo> option) {
		List<ModelChecker<StoracInfo>> queue = new ArrayList<>();		
		ModelChecker<StoracInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoracInfo>> buildActionsOnPassedHook(DeciTreeOption<StoracInfo> option) {
		List<ActionStd<StoracInfo>> actions = new ArrayList<>();

		ActionStd<StoracInfo> mergeCalonthLtm = new StdStoracMergeCalonthLtm(option);
		ActionLazy<StoracInfo> nodeL1 = new LazyStoracNodeSelectLtm(option.conn, option.schemaName);
		ActionLazy<StoracInfo> zerofy = new LazyStoracNodeZerofy(option.conn, option.schemaName);		
		
		mergeCalonthLtm.addPostAction(nodeL1);
		nodeL1.addPostAction(zerofy);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
