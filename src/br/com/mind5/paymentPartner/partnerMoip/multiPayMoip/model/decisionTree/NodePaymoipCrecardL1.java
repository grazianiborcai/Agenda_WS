package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipNodeCrecardL2;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.StdPaymoipMergeCrecard;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.checker.PaymoipCheckCrecarch;

public final class NodePaymoipCrecardL1 extends DeciTreeTemplateWrite<PaymoipInfo> {
	
	public NodePaymoipCrecardL1(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaymoipInfo> buildCheckerHook(DeciTreeOption<PaymoipInfo> option) {	
		List<ModelChecker<PaymoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PaymoipInfo> checker;
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new PaymoipCheckCrecarch(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaymoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymoipInfo> option) {
		List<ActionStd<PaymoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<PaymoipInfo> mergeCrecard = new StdPaymoipMergeCrecard(option);
		ActionLazy<PaymoipInfo> nodeL2 = new LazyPaymoipNodeCrecardL2(option.conn, option.schemaName);
		
		mergeCrecard.addPostAction(nodeL2);
		
		actions.add(mergeCrecard);		
		return actions;
	}
}
