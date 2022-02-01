package br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.action.LazyStoraciveRootSelect;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.action.StdStoraciveMergeCalonthLtm;


public final class RootStoraciveSelectLtm extends DeciTreeTemplateWrite<StoraciveInfo> {
	
	public RootStoraciveSelectLtm(DeciTreeOption<StoraciveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoraciveInfo> buildCheckerHook(DeciTreeOption<StoraciveInfo> option) {
		List<ModelChecker<StoraciveInfo>> queue = new ArrayList<>();		
		ModelChecker<StoraciveInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoraciveInfo>> buildActionsOnPassedHook(DeciTreeOption<StoraciveInfo> option) {
		List<ActionStd<StoraciveInfo>> actions = new ArrayList<>();

		ActionStd<StoraciveInfo> mergeCalonthLtm = new StdStoraciveMergeCalonthLtm(option);
		ActionLazy<StoraciveInfo> select = new LazyStoraciveRootSelect(option.conn, option.schemaName);
		
		mergeCalonthLtm.addPostAction(select);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
