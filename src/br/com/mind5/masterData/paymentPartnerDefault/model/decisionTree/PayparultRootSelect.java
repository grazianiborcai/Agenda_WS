package br.com.mind5.masterData.paymentPartnerDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;
import br.com.mind5.masterData.paymentPartnerDefault.model.action.PayparultVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PayparultRootSelect extends DeciTreeTemplateRead<PayparultInfo> {
	
	public PayparultRootSelect(DeciTreeOption<PayparultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PayparultInfo> buildCheckerHook(DeciTreeOption<PayparultInfo> option) {
		List<ModelChecker<PayparultInfo>> queue = new ArrayList<>();		
		ModelChecker<PayparultInfo> checker;

		checker = new ModelCheckerDummy<PayparultInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<PayparultInfo>> buildActionsOnPassedHook(DeciTreeOption<PayparultInfo> option) {
		List<ActionStd<PayparultInfo>> actions = new ArrayList<>();
		
		ActionStd<PayparultInfo> select = new ActionStdCommom<PayparultInfo>(option, PayparultVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
