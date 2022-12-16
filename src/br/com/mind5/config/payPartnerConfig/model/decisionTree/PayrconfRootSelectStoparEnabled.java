package br.com.mind5.config.payPartnerConfig.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.config.payPartnerConfig.model.action.PayrconfVisiNodeSelectStoparEnabled;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PayrconfRootSelectStoparEnabled extends DeciTreeTemplateRead<PayrconfInfo> {
	
	public PayrconfRootSelectStoparEnabled(DeciTreeOption<PayrconfInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayrconfInfo> buildCheckerHook(DeciTreeOption<PayrconfInfo> option) {
		List<ModelChecker<PayrconfInfo>> queue = new ArrayList<>();		
		ModelChecker<PayrconfInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayrconfInfo>> buildActionsOnPassedHook(DeciTreeOption<PayrconfInfo> option) {
		List<ActionStd<PayrconfInfo>> actions = new ArrayList<>();

		ActionStd<PayrconfInfo> select = new PayrconfRootSelect(option).toAction();
		ActionLazy<PayrconfInfo> nodeL1 = new ActionLazyCommom<PayrconfInfo>(option, PayrconfVisiNodeSelectStoparEnabled.class);
		
		select.addPostAction(nodeL1);
		
		actions.add(select);
		return actions;
	}
}
