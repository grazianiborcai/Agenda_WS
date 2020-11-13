package br.com.mind5.payment.payOrderItemSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.action.StdPayormarchMergeToSelect;
import br.com.mind5.payment.payOrderItemSearch.model.checker.PayormarchCheckRead;

public final class RootPayormarchSelect extends DeciTreeTemplateWriteV2<PayormarchInfo> {
	
	public RootPayormarchSelect(DeciTreeOption<PayormarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayormarchInfo> buildCheckerHook(DeciTreeOption<PayormarchInfo> option) {
		List<ModelCheckerV1<PayormarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayormarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayormarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PayormarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PayormarchInfo> option) {
		List<ActionStdV2<PayormarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<PayormarchInfo> select = new StdPayormarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
