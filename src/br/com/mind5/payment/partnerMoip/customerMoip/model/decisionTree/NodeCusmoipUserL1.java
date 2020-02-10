package br.com.mind5.payment.partnerMoip.customerMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.payment.partnerMoip.customerMoip.model.action.LazyCusmoipNodeUserL2;
import br.com.mind5.payment.partnerMoip.customerMoip.model.action.StdCusmoipMergeUselis;
import br.com.mind5.payment.partnerMoip.customerMoip.model.checker.CusmoipCheckDummy;

public final class NodeCusmoipUserL1 extends DeciTreeWriteTemplate<CusmoipInfo> {
	
	public NodeCusmoipUserL1(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusmoipInfo> buildDecisionCheckerHook(DeciTreeOption<CusmoipInfo> option) {
		List<ModelChecker<CusmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CusmoipInfo> checker;	

		checker = new CusmoipCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CusmoipInfo> option) {
		List<ActionStd<CusmoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CusmoipInfo> mergeUselis = new StdCusmoipMergeUselis(option);
		ActionLazy<CusmoipInfo> nodeL2 = new LazyCusmoipNodeUserL2(option.conn, option.schemaName);
		
		mergeUselis.addPostAction(nodeL2);
		
		actions.add(mergeUselis);
		return actions;
	}
}
