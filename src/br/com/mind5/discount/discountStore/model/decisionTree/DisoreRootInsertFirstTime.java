package br.com.mind5.discount.discountStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiRootInsert;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiEnforceFirstTimeKey;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiEnforceFirstTimeStrategy;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiEnforceInactive;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiEnforcePercentDefault;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiEnforceValidFromMin;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiEnforceValidToMax;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class DisoreRootInsertFirstTime extends DeciTreeTemplateWrite<DisoreInfo> {
	
	public DisoreRootInsertFirstTime(DeciTreeOption<DisoreInfo> option) {
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
		
		ActionStd<DisoreInfo> enforceKey = new ActionStdCommom<DisoreInfo>(option, DisoreVisiEnforceFirstTimeKey.class);
		ActionLazy<DisoreInfo> enforceStrategy = new ActionLazyCommom<DisoreInfo>(option, DisoreVisiEnforceFirstTimeStrategy.class);
		ActionLazy<DisoreInfo> enforceValidFrom = new ActionLazyCommom<DisoreInfo>(option, DisoreVisiEnforceValidFromMin.class);
		ActionLazy<DisoreInfo> enforceValidTo = new ActionLazyCommom<DisoreInfo>(option, DisoreVisiEnforceValidToMax.class);
		ActionLazy<DisoreInfo> enforceInactive = new ActionLazyCommom<DisoreInfo>(option, DisoreVisiEnforceInactive.class);
		ActionLazy<DisoreInfo> enforcePricePercent = new ActionLazyCommom<DisoreInfo>(option, DisoreVisiEnforcePercentDefault.class);
		ActionLazy<DisoreInfo> insert = new ActionLazyCommom<DisoreInfo>(option, DisoreVisiRootInsert.class);
		
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
