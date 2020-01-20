package br.com.mind5.business.orderList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.action.LazyOrdistRootSelect;
import br.com.mind5.business.orderList.model.action.StdOrdistMergeOrdarch;
import br.com.mind5.business.orderList.model.checker.OrdistCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootOrdistSearch extends DeciTreeReadTemplate<OrdistInfo> {
	
	public RootOrdistSearch(DeciTreeOption<OrdistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdistInfo> buildDecisionCheckerHook(DeciTreeOption<OrdistInfo> option) {
		List<ModelChecker<OrdistInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdistInfo> checker;
		
		checker = new OrdistCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
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
