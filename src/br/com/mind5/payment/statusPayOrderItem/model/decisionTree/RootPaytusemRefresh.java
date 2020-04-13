package br.com.mind5.payment.statusPayOrderItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.payment.statusPayOrderItem.model.action.LazyPaytusemNodeRefresh;
import br.com.mind5.payment.statusPayOrderItem.model.checker.PaytusemCheckOwner;
import br.com.mind5.payment.statusPayOrderItem.model.checker.PaytusemCheckRefresh;

public final class RootPaytusemRefresh extends DeciTreeTemplateWriteV1<PaytusemInfo> {
	
	public RootPaytusemRefresh(DeciTreeOption<PaytusemInfo> option) {
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
		checker = new PaytusemCheckRefresh(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PaytusemCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PaytusemInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusemInfo> option) {
		List<ActionStdV1<PaytusemInfo>> actions = new ArrayList<>();		

		ActionStdV1<PaytusemInfo> select = new RootPaytusemSelect(option).toAction();	
		ActionLazyV1<PaytusemInfo> nodeRefresh = new LazyPaytusemNodeRefresh(option.conn, option.schemaName);
		
		select.addPostAction(nodeRefresh);
		
		actions.add(select);		
		return actions;
	}
}
