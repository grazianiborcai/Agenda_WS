package br.com.mind5.config.payPartnerStoreCreation.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.config.payPartnerStoreCreation.info.PayrsocreInfo;
import br.com.mind5.config.payPartnerStoreCreation.model.action.PayrsocreVisiNodeSelectEnabled;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PayrsocreRootSelectEnabled extends DeciTreeTemplateRead<PayrsocreInfo> {
	
	public PayrsocreRootSelectEnabled(DeciTreeOption<PayrsocreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayrsocreInfo> buildCheckerHook(DeciTreeOption<PayrsocreInfo> option) {
		List<ModelChecker<PayrsocreInfo>> queue = new ArrayList<>();		
		ModelChecker<PayrsocreInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PayrsocreInfo>> buildActionsOnPassedHook(DeciTreeOption<PayrsocreInfo> option) {
		List<ActionStd<PayrsocreInfo>> actions = new ArrayList<>();

		ActionStd<PayrsocreInfo> select = new PayrsocreRootSelect(option).toAction();
		ActionLazy<PayrsocreInfo> nodeL1 = new ActionLazyCommom<PayrsocreInfo>(option, PayrsocreVisiNodeSelectEnabled.class);
		
		select.addPostAction(nodeL1);
		
		actions.add(select);
		return actions;
	}
}
