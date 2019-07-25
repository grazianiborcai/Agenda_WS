package br.com.gda.payment.payOrderStatus.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.payOrderStatus.info.PaytusInfo;
import br.com.gda.payment.payOrderStatus.model.action.LazyPaytusMergeCuspar;
import br.com.gda.payment.payOrderStatus.model.action.LazyPaytusPaytusemRefresh;
import br.com.gda.payment.payOrderStatus.model.action.StdPaytusMergePayord;
import br.com.gda.payment.payOrderStatus.model.checker.PaytusCheckSelect;

public final class RootPaytusRefresh extends DeciTreeWriteTemplate<PaytusInfo> {
	
	public RootPaytusRefresh(DeciTreeOption<PaytusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaytusInfo> buildDecisionCheckerHook(DeciTreeOption<PaytusInfo> option) {
		List<ModelChecker<PaytusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaytusInfo> checker;	
		
		checker = new PaytusCheckSelect();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaytusInfo>> buildActionsOnPassedHook(DeciTreeOption<PaytusInfo> option) {
		List<ActionStd<PaytusInfo>> actions = new ArrayList<>();		

		ActionStd<PaytusInfo> mergePayord = new StdPaytusMergePayord(option);	
		ActionLazy<PaytusInfo> mergeCuspar = new LazyPaytusMergeCuspar(option.conn, option.schemaName);	
		ActionLazy<PaytusInfo> paytusemRefresh = new LazyPaytusPaytusemRefresh(option.conn, option.schemaName);		
		
		mergePayord.addPostAction(mergeCuspar);
		mergeCuspar.addPostAction(paytusemRefresh);
		
		actions.add(mergePayord);		
		return actions;
	}
}
