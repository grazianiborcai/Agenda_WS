package br.com.mind5.config.payPartnerCustomerCreation.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.payPartnerCustomerCreation.info.PayrcucreInfo;
import br.com.mind5.config.payPartnerCustomerCreation.model.action.PayrcucreVisiNodeSelectEnabled;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PayrcucreRootSelectEnabled extends DeciTreeTemplateRead<PayrcucreInfo> {
	
	public PayrcucreRootSelectEnabled(DeciTreeOption<PayrcucreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayrcucreInfo> buildCheckerHook(DeciTreeOption<PayrcucreInfo> option) {
		List<ModelChecker<PayrcucreInfo>> queue = new ArrayList<>();		
		ModelChecker<PayrcucreInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayrcucreInfo>> buildActionsOnPassedHook(DeciTreeOption<PayrcucreInfo> option) {
		List<ActionStd<PayrcucreInfo>> actions = new ArrayList<>();

		ActionStd<PayrcucreInfo> select = new PayrcucreRootSelect(option).toAction();
		ActionLazy<PayrcucreInfo> nodeL1 = new ActionLazyCommom<PayrcucreInfo>(option, PayrcucreVisiNodeSelectEnabled.class);
		
		select.addPostAction(nodeL1);
		
		actions.add(select);
		return actions;
	}
}
