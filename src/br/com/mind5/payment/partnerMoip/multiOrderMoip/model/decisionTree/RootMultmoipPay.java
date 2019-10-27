package br.com.mind5.payment.partnerMoip.multiOrderMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.model.action.LazyMultmoipPaymoipPay;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.model.checker.MultmoipCheckPay;

public final class RootMultmoipPay extends DeciTreeReadTemplate<MultmoipInfo> {
	
	public RootMultmoipPay(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MultmoipInfo> buildDecisionCheckerHook(DeciTreeOption<MultmoipInfo> option) {	
		List<ModelChecker<MultmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<MultmoipInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MultmoipCheckPay(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MultmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<MultmoipInfo> option) {
		List<ActionStd<MultmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<MultmoipInfo> nodePlace = new NodeMultmoipPlace(option).toAction();
		ActionLazy<MultmoipInfo> payOrder = new LazyMultmoipPaymoipPay(option.conn, option.schemaName);
		
		nodePlace.addPostAction(payOrder);
		
		actions.add(nodePlace);		
		return actions;
	}
}
