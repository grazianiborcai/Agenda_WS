package br.com.mind5.discount.discountStoreSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.discount.discountStoreSearch.model.action.LazyDisorarchEnforceStrategyFirstTime;
import br.com.mind5.discount.discountStoreSearch.model.action.LazyDisorarchRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootDisorarchSelectFirstTime extends DeciTreeTemplateRead<DisorarchInfo> {
	
	public RootDisorarchSelectFirstTime(DeciTreeOption<DisorarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DisorarchInfo> buildCheckerHook(DeciTreeOption<DisorarchInfo> option) {
		List<ModelChecker<DisorarchInfo>> queue = new ArrayList<>();		
		ModelChecker<DisorarchInfo> checker;
	
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<DisorarchInfo>> buildActionsOnPassedHook(DeciTreeOption<DisorarchInfo> option) {
		List<ActionStd<DisorarchInfo>> actions = new ArrayList<>();
		
		ActionStd<DisorarchInfo> nodeActive	= new NodeDisorarchActive(option).toAction();
		ActionLazy<DisorarchInfo> enforceStrategy = new LazyDisorarchEnforceStrategyFirstTime(option.conn, option.schemaName);
		ActionLazy<DisorarchInfo> select = new LazyDisorarchRootSelect(option.conn, option.schemaName);
		
		nodeActive.addPostAction(enforceStrategy);
		enforceStrategy.addPostAction(select);
		
		actions.add(nodeActive);
		return actions;
	}
}
