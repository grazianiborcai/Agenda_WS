package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.PaymentStatusInfo;
import br.com.mind5.business.masterData.model.action.StdPaymentStatusSelect;
import br.com.mind5.business.masterData.model.checker.PaymentStatusCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootPaymentStatusSelect extends DeciTreeReadTemplate<PaymentStatusInfo> {
	
	public RootPaymentStatusSelect(DeciTreeOption<PaymentStatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaymentStatusInfo> buildDecisionCheckerHook(DeciTreeOption<PaymentStatusInfo> option) {
		List<ModelChecker<PaymentStatusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaymentStatusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaymentStatusCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<PaymentStatusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymentStatusInfo> option) {
		List<ActionStd<PaymentStatusInfo>> actions = new ArrayList<>();
		
		ActionStd<PaymentStatusInfo> select = new StdPaymentStatusSelect(option);
		
		actions.add(select);
		return actions;
	}
}
