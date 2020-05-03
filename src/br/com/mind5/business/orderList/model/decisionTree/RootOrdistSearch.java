package br.com.mind5.business.orderList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.action.LazyOrdistRootSelect;
import br.com.mind5.business.orderList.model.action.StdOrdistMergeOrdarch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootOrdistSearch extends DeciTreeTemplateReadV2<OrdistInfo> {
	
	public RootOrdistSearch(DeciTreeOption<OrdistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrdistInfo> buildCheckerHook(DeciTreeOption<OrdistInfo> option) {
		List<ModelCheckerV1<OrdistInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrdistInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
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
