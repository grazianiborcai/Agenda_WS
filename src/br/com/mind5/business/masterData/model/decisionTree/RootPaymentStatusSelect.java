package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.PaymentStatusInfo;
import br.com.mind5.business.masterData.model.action.StdPaymentStatusSelect;
import br.com.mind5.business.masterData.model.checker.PaymentStatusCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootPaymentStatusSelect extends DeciTreeTemplateReadV1<PaymentStatusInfo> {
	
	public RootPaymentStatusSelect(DeciTreeOption<PaymentStatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PaymentStatusInfo> buildCheckerHook(DeciTreeOption<PaymentStatusInfo> option) {
		List<ModelCheckerV1<PaymentStatusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PaymentStatusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaymentStatusCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<PaymentStatusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymentStatusInfo> option) {
		List<ActionStdV1<PaymentStatusInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PaymentStatusInfo> select = new StdPaymentStatusSelect(option);
		
		actions.add(select);
		return actions;
	}
}
