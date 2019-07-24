package br.com.gda.payment.partnerMoip.multiOrderMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.action.LazyMultmoipOrdmoipRead;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.action.LazyMultmoipPaymoipPay;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.checker.MultmoipCheckPay;

public final class RootMultmoipPay extends DeciTreeWriteTemplate<MultmoipInfo> {
	
	public RootMultmoipPay(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MultmoipInfo> buildDecisionCheckerHook(DeciTreeOption<MultmoipInfo> option) {	
		List<ModelChecker<MultmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<MultmoipInfo> checker;
		
		checker = new MultmoipCheckPay();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MultmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<MultmoipInfo> option) {
		List<ActionStd<MultmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<MultmoipInfo> nodePlace = new NodeMultmoipPlace(option).toAction();
		ActionLazy<MultmoipInfo> payOrder = new LazyMultmoipPaymoipPay(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> readOrder = new LazyMultmoipOrdmoipRead(option.conn, option.schemaName);
		
		nodePlace.addPostAction(payOrder);
		payOrder.addPostAction(readOrder);
		
		actions.add(nodePlace);		
		return actions;
	}
}
