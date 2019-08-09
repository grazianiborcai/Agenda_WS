package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.PaymentStatusInfo;
import br.com.gda.business.masterData.model.action.StdPaymentStatusSelect;
import br.com.gda.business.masterData.model.checker.PaymentStatusCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootPaymentStatusSelect extends DeciTreeReadTemplate<PaymentStatusInfo> {
	
	public RootPaymentStatusSelect(DeciTreeOption<PaymentStatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaymentStatusInfo> buildDecisionCheckerHook(DeciTreeOption<PaymentStatusInfo> option) {
		List<ModelChecker<PaymentStatusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaymentStatusInfo> checker;
		
		checker = new PaymentStatusCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<PaymentStatusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymentStatusInfo> option) {
		List<ActionStd<PaymentStatusInfo>> actions = new ArrayList<>();
		
		actions.add(new StdPaymentStatusSelect(option));
		return actions;
	}
}
