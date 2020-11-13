package br.com.mind5.business.orderSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.model.action.LazyOrdarchPruneInactive;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootOrdarchSelectActive extends DeciTreeTemplateRead<OrdarchInfo> {
	
	public RootOrdarchSelectActive(DeciTreeOption<OrdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdarchInfo> buildCheckerHook(DeciTreeOption<OrdarchInfo> option) {
		List<ModelChecker<OrdarchInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdarchInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdarchInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdarchInfo> option) {
		List<ActionStd<OrdarchInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdarchInfo> select = new RootOrdarchSelect(option).toAction();
		ActionLazy<OrdarchInfo> pruneInactive = new LazyOrdarchPruneInactive(option.conn, option.schemaName);
		
		select.addPostAction(pruneInactive);
		
		actions.add(select);			
		return actions;
	}
}
