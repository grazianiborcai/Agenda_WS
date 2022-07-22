package br.com.mind5.payment.statusPayOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.action.PaytusVisiNodeRefresh;
import br.com.mind5.payment.statusPayOrder.model.action.PaytusVisiPaytusemRefresh;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckOwner;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckPayord;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckRefresh;

public final class PaytusRootRefresh extends DeciTreeTemplateWrite<PaytusInfo> {
	
	public PaytusRootRefresh(DeciTreeOption<PaytusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaytusInfo> buildCheckerHook(DeciTreeOption<PaytusInfo> option) {
		List<ModelChecker<PaytusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusInfo> checker;	
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	//TODO: por padrao, um pagamento com mais de 180 dias nao pode ser alterado. Nao refrescar pagamentos antigos ?
	@Override protected List<ActionStd<PaytusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusInfo> option) {
		List<ActionStd<PaytusInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusInfo> selectToRefresh = new PaytusRootSelect(option).toAction();
		ActionLazy<PaytusInfo> nodeRefresh = new ActionLazyCommom<PaytusInfo>(option, PaytusVisiNodeRefresh.class);	
		ActionLazy<PaytusInfo> paytusemRefresh = new ActionLazyCommom<PaytusInfo>(option, PaytusVisiPaytusemRefresh.class);		
		ActionStd<PaytusInfo> selectOutput = new PaytusRootSelect(option).toAction();	
		
		selectToRefresh.addPostAction(nodeRefresh);
		nodeRefresh.addPostAction(paytusemRefresh);
		
		actions.add(selectToRefresh);		
		actions.add(selectOutput);
		return actions;
	}
}
