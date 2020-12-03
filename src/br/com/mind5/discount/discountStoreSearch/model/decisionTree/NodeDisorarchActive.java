package br.com.mind5.discount.discountStoreSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.discount.discountStoreSearch.model.action.LazyDisorarchEnforceActive;
import br.com.mind5.discount.discountStoreSearch.model.action.LazyDisorarchEnforceValidFrom;
import br.com.mind5.discount.discountStoreSearch.model.action.LazyDisorarchEnforceValidTo;
import br.com.mind5.discount.discountStoreSearch.model.action.StdDisorarchEnforceKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class NodeDisorarchActive extends DeciTreeTemplateRead<DisorarchInfo> {
	
	public NodeDisorarchActive(DeciTreeOption<DisorarchInfo> option) {
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
		
		ActionStd<DisorarchInfo> enforceKey	= new StdDisorarchEnforceKey(option);
		ActionLazy<DisorarchInfo> enforceActive = new LazyDisorarchEnforceActive(option.conn, option.schemaName);
		ActionLazy<DisorarchInfo> enforceValidFrom = new LazyDisorarchEnforceValidFrom(option.conn, option.schemaName);
		ActionLazy<DisorarchInfo> enforceValidTo = new LazyDisorarchEnforceValidTo(option.conn, option.schemaName);
		
		enforceKey.addPostAction(enforceActive);
		enforceActive.addPostAction(enforceValidFrom);
		enforceValidFrom.addPostAction(enforceValidTo);
		
		actions.add(enforceKey);
		return actions;
	}
}
