package br.com.mind5.business.orderSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.action.LazyOrdarchPruneInactive;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootOrdarchSelectActive extends DeciTreeTemplateReadV2<OrdarchInfo> {
	
	public RootOrdarchSelectActive(DeciTreeOption<OrdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrdarchInfo> buildCheckerHook(DeciTreeOption<OrdarchInfo> option) {
		List<ModelCheckerV1<OrdarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrdarchInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OrdarchInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdarchInfo> option) {
		List<ActionStdV2<OrdarchInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<OrdarchInfo> select = new RootOrdarchSelect(option).toAction();
		ActionLazy<OrdarchInfo> pruneInactive = new LazyOrdarchPruneInactive(option.conn, option.schemaName);
		
		select.addPostAction(pruneInactive);
		
		actions.add(select);			
		return actions;
	}
}
