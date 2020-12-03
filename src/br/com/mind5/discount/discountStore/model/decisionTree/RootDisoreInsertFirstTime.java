package br.com.mind5.discount.discountStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.model.action.LazyDisoreEnforceFirstTimeStrategy;
import br.com.mind5.discount.discountStore.model.action.LazyDisoreEnforceInactive;
import br.com.mind5.discount.discountStore.model.action.LazyDisoreEnforcePercentDefault;
import br.com.mind5.discount.discountStore.model.action.LazyDisoreEnforceValidFromMin;
import br.com.mind5.discount.discountStore.model.action.LazyDisoreEnforceValidToMax;
import br.com.mind5.discount.discountStore.model.action.LazyDisoreRootInsert;
import br.com.mind5.discount.discountStore.model.action.StdDisoreEnforceFirstTimeKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootDisoreInsertFirstTime extends DeciTreeTemplateWrite<DisoreInfo> {
	
	public RootDisoreInsertFirstTime(DeciTreeOption<DisoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DisoreInfo> buildCheckerHook(DeciTreeOption<DisoreInfo> option) {
		List<ModelChecker<DisoreInfo>> queue = new ArrayList<>();		
		ModelChecker<DisoreInfo> checker;		
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<DisoreInfo>> buildActionsOnPassedHook(DeciTreeOption<DisoreInfo> option) {
		List<ActionStd<DisoreInfo>> actions = new ArrayList<>();
		
		ActionStd<DisoreInfo> enforceKey = new StdDisoreEnforceFirstTimeKey(option);
		ActionLazy<DisoreInfo> enforceStrategy = new LazyDisoreEnforceFirstTimeStrategy(option.conn, option.schemaName);
		ActionLazy<DisoreInfo> enforceValidFrom = new LazyDisoreEnforceValidFromMin(option.conn, option.schemaName);
		ActionLazy<DisoreInfo> enforceValidTo = new LazyDisoreEnforceValidToMax(option.conn, option.schemaName);
		ActionLazy<DisoreInfo> enforceInactive = new LazyDisoreEnforceInactive(option.conn, option.schemaName);
		ActionLazy<DisoreInfo> enforcePricePercent = new LazyDisoreEnforcePercentDefault(option.conn, option.schemaName);
		ActionLazy<DisoreInfo> insert = new LazyDisoreRootInsert(option.conn, option.schemaName);
		
		enforceKey.addPostAction(enforceStrategy);
		enforceStrategy.addPostAction(enforceValidFrom);
		enforceValidFrom.addPostAction(enforceValidTo);
		enforceValidTo.addPostAction(enforceInactive);
		enforceInactive.addPostAction(enforcePricePercent);
		enforcePricePercent.addPostAction(insert);
		
		actions.add(enforceKey);
		return actions;
	}
}
