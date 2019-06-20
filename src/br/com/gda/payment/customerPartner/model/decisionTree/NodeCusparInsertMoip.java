package br.com.gda.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.model.action.LazyCusparEnforceLChanged;
import br.com.gda.payment.customerPartner.model.action.LazyCusparInsert;
import br.com.gda.payment.customerPartner.model.action.LazyCusparMergeUser;
import br.com.gda.payment.customerPartner.model.action.StdCusparMergeSetupar;
import br.com.gda.payment.customerPartner.model.checker.CusparCheckIsMoip;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCusparInsertMoip extends DeciTreeWriteTemplate<CusparInfo> {
	
	public NodeCusparInsertMoip(DeciTreeOption<CusparInfo> option) {
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
		
		ActionStd<CusparInfo> mergesetupar = new StdCusparMergeSetupar(option);
		ActionLazy<CusparInfo> mergeUser = new LazyCusparMergeUser(option.conn, option.schemaName);
		ActionLazy<CusparInfo> enforceLChanged = new LazyCusparEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<CusparInfo> insert = new LazyCusparInsert(option.conn, option.schemaName);
		
		mergesetupar.addPostAction(mergeUser);
		mergeUser.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(insert);
		
		actions.add(mergesetupar);
		return actions;
	}
}
