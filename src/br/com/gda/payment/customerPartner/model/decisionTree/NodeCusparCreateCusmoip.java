package br.com.gda.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.model.action.LazyCusparCreateCusmoip;
import br.com.gda.payment.customerPartner.model.action.LazyCusparUpdate;
import br.com.gda.payment.customerPartner.model.action.StdCusparMergeSetupar;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckIsMoip;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCusparCreateCusmoip extends DeciTreeWriteTemplate<CusparInfo> {
	
	public NodeCusparCreateCusmoip(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusparInfo> buildDecisionCheckerHook(DeciTreeOption<CusparInfo> option) {
		List<ModelChecker<CusparInfo>> queue = new ArrayList<>();		
		ModelChecker<CusparInfo> checker;
		
		checker = new CusparCheckIsMoip();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStd<CusparInfo>> actions = new ArrayList<>();
		
		ActionStd<CusparInfo> mergeSetupar = new StdCusparMergeSetupar(option);
		ActionLazy<CusparInfo> createCusmoip = new LazyCusparCreateCusmoip(option.conn, option.schemaName);
		ActionLazy<CusparInfo> update = new LazyCusparUpdate(option.conn, option.schemaName);
		
		mergeSetupar.addPostAction(createCusmoip);
		createCusmoip.addPostAction(update);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
