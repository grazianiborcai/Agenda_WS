package br.com.mind5.payment.statusPayOrder.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.payment.statusPayOrder.model.action.LazyPaytusMergeCuspar;
import br.com.mind5.payment.statusPayOrder.model.action.LazyPaytusNodeRefresh;
import br.com.mind5.payment.statusPayOrder.model.action.LazyPaytusPaytusemRefresh;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckOwner;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckPayord;
import br.com.mind5.payment.statusPayOrder.model.checker.PaytusCheckRefresh;

public final class RootPaytusRefresh extends DeciTreeWriteTemplate<PaytusInfo> {
	
	public RootPaytusRefresh(DeciTreeOption<PaytusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaytusInfo> buildDecisionCheckerHook(DeciTreeOption<PaytusInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PaytusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PaytusCheckRefresh();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PaytusCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PaytusCheckPayord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	//TODO: por padrao, um pagamento com mais de 180 dias nao pode ser alterado. Nao refrescar pagamentos antigos ?
	@Override protected List<ActionStd<PaytusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusInfo> option) {
		List<ActionStd<PaytusInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusInfo> selectToRefresh = new RootPaytusSelect(option).toAction();	
		ActionLazy<PaytusInfo> mergeCuspar = new LazyPaytusMergeCuspar(option.conn, option.schemaName);	
		ActionLazy<PaytusInfo> nodeRefresh = new LazyPaytusNodeRefresh(option.conn, option.schemaName);	
		ActionLazy<PaytusInfo> paytusemRefresh = new LazyPaytusPaytusemRefresh(option.conn, option.schemaName);		
		ActionStd<PaytusInfo> selectOutput = new RootPaytusSelect(option).toAction();	
		
		selectToRefresh.addPostAction(mergeCuspar);
		mergeCuspar.addPostAction(nodeRefresh);
		mergeCuspar.addPostAction(paytusemRefresh);
		
		actions.add(selectToRefresh);		
		actions.add(selectOutput);
		return actions;
	}
}
