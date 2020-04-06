package br.com.mind5.payment.statusPayOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.payment.statusPayOrderItem.model.action.StdPaytusemMergePayordem;
import br.com.mind5.payment.statusPayOrderItem.model.checker.PaytusemCheckLangu;
import br.com.mind5.payment.statusPayOrderItem.model.checker.PaytusemCheckRead;

public final class RootPaytusemSelect extends DeciTreeTemplateRead<PaytusemInfo> {
	
	public RootPaytusemSelect(DeciTreeOption<PaytusemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PaytusemInfo> buildCheckerHook(DeciTreeOption<PaytusemInfo> option) {
		List<ModelCheckerV1<PaytusemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PaytusemInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaytusemCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PaytusemCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PaytusemInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStdV1<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStdV1<PaytusemInfo> mergePayordem = new StdPaytusemMergePayordem(option);	
		
		actions.add(mergePayordem);		
		return actions;
	}
}
