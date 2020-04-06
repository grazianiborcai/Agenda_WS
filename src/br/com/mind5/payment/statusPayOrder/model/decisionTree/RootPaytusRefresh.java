package br.com.mind5.payment.statusPayOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.action.LazyPaytusNodeRefresh;
import br.com.mind5.payment.statusPayOrder.model.action.LazyPaytusPaytusemRefresh;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckOwner;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckPayord;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckRefresh;

public final class RootPaytusRefresh extends DeciTreeTemplateWrite<PaytusInfo> {
	
	public RootPaytusRefresh(DeciTreeOption<PaytusInfo> option) {
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
	
	
	//TODO: por padrao, um pagamento com mais de 180 dias nao pode ser alterado. Nao refrescar pagamentos antigos ?
	@Override protected List<ActionStdV1<PaytusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusInfo> option) {
		List<ActionStdV1<PaytusInfo>> actions = new ArrayList<>();		

		ActionStdV1<PaytusInfo> selectToRefresh = new RootPaytusSelect(option).toAction();
		ActionLazyV1<PaytusInfo> nodeRefresh = new LazyPaytusNodeRefresh(option.conn, option.schemaName);	
		ActionLazyV1<PaytusInfo> paytusemRefresh = new LazyPaytusPaytusemRefresh(option.conn, option.schemaName);		
		ActionStdV1<PaytusInfo> selectOutput = new RootPaytusSelect(option).toAction();	
		
		selectToRefresh.addPostAction(nodeRefresh);
		nodeRefresh.addPostAction(paytusemRefresh);
		
		actions.add(selectToRefresh);		
		actions.add(selectOutput);
		return actions;
	}
}
