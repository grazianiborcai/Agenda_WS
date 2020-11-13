package br.com.mind5.business.orderList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.action.LazyOrdistRootSelect;
import br.com.mind5.business.orderList.model.action.StdOrdistMergeOrdarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootOrdistSearch extends DeciTreeTemplateRead<OrdistInfo> {
	
	public RootOrdistSearch(DeciTreeOption<OrdistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdistInfo> buildCheckerHook(DeciTreeOption<OrdistInfo> option) {
		List<ModelChecker<OrdistInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdistInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdistInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdistInfo> option) {
		List<ActionStd<OrdistInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdistInfo> mergeOrdarch = new StdOrdistMergeOrdarch(option);
		ActionLazy<OrdistInfo> select = new LazyOrdistRootSelect(option.conn, option.schemaName);
		
		mergeOrdarch.addPostAction(select);
		
		actions.add(mergeOrdarch);			
		return actions;
	}
}
