package br.com.mind5.payment.statusPayOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.action.LazyPaytusRootRefresh;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckOwner;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckPayord;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckRefresh;

public final class RootPaytusRefreshAuth extends DeciTreeTemplateWriteV2<PaytusInfo> {
	
	public RootPaytusRefreshAuth(DeciTreeOption<PaytusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PaytusInfo> buildCheckerHook(DeciTreeOption<PaytusInfo> option) {
		List<ModelCheckerV1<PaytusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PaytusInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaytusCheckRefresh(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PaytusCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PaytusCheckPayord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	

	@Override protected List<ActionStdV1<PaytusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusInfo> option) {
		List<ActionStdV1<PaytusInfo>> actions = new ArrayList<>();		

		ActionStdV1<PaytusInfo> nodeUserL1 = new NodePaytusUserL1(option).toAction();
		ActionLazyV1<PaytusInfo> nodeRefresh = new LazyPaytusRootRefresh(option.conn, option.schemaName);	
		
		nodeUserL1.addPostAction(nodeRefresh);
		
		actions.add(nodeUserL1);
		return actions;
	}
}
