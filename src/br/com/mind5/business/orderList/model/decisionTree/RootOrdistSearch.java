package br.com.mind5.business.orderList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.action.LazyOrdistRootSelect;
import br.com.mind5.business.orderList.model.action.StdOrdistMergeOrdarch;
import br.com.mind5.business.orderList.model.checker.OrdistCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootOrdistSearch extends DeciTreeReadTemplate<OrdistInfo> {
	
	public RootOrdistSearch(DeciTreeOption<OrdistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdistInfo> buildCheckerHook(DeciTreeOption<OrdistInfo> option) {
		List<ModelChecker<OrdistInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdistInfo> checker;
		
		checker = new OrdistCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrdistInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdistInfo> option) {
		List<ActionStdV1<OrdistInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<OrdistInfo> mergeOrdarch = new StdOrdistMergeOrdarch(option);
		ActionLazyV1<OrdistInfo> select = new LazyOrdistRootSelect(option.conn, option.schemaName);
		
		mergeOrdarch.addPostAction(select);
		
		actions.add(mergeOrdarch);			
		return actions;
	}
}
