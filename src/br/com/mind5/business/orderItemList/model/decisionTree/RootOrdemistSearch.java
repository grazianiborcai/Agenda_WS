package br.com.mind5.business.orderItemList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderItemList.model.action.LazyOrdemistRootSelect;
import br.com.mind5.business.orderItemList.model.action.StdOrdemistMergeOrdemarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootOrdemistSearch extends DeciTreeTemplateWrite<OrdemistInfo> {
	
	public RootOrdemistSearch(DeciTreeOption<OrdemistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdemistInfo> buildCheckerHook(DeciTreeOption<OrdemistInfo> option) {
		List<ModelChecker<OrdemistInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdemistInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdemistInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdemistInfo> option) {
		List<ActionStd<OrdemistInfo>> actions = new ArrayList<>();
		
		ActionStd<OrdemistInfo> mergeOrdemarch = new StdOrdemistMergeOrdemarch(option);
		ActionLazy<OrdemistInfo> select = new LazyOrdemistRootSelect(option.conn, option.schemaName);
		
		mergeOrdemarch.addPostAction(select);
		
		actions.add(mergeOrdemarch);
		return actions;
	}
}
