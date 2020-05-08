package br.com.mind5.masterData.paymentStatus.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.paymentStatus.info.PaymenusInfo;
import br.com.mind5.masterData.paymentStatus.model.action.StdPaymenusDaoSelect;
import br.com.mind5.masterData.paymentStatus.model.checker.PaymenusCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootPaymenusSelect extends DeciTreeTemplateReadV1<PaymenusInfo> {
	
	public RootPaymenusSelect(DeciTreeOption<PaymenusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PaymenusInfo> buildCheckerHook(DeciTreeOption<PaymenusInfo> option) {
		List<ModelCheckerV1<PaymenusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PaymenusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaymenusCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<PaymenusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymenusInfo> option) {
		List<ActionStdV1<PaymenusInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PaymenusInfo> select = new StdPaymenusDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
