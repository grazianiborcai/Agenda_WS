package br.com.gda.payment.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipNodePlaceL2;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.StdOrdmoipEnforceMatTxt;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckMatData;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckPayordemData;

public final class NodeOrdmoipPlaceMat extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public NodeOrdmoipPlaceMat(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildDecisionCheckerHook(DeciTreeOption<OrdmoipInfo> option) {			
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;
		
		checker = new OrdmoipCheckPayordemData();
		queue.add(checker);
		
		checker = new OrdmoipCheckMatData();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> enforceMatTxt = new StdOrdmoipEnforceMatTxt(option);	
		ActionLazy<OrdmoipInfo> nodePlaceL2 = new LazyOrdmoipNodePlaceL2(option.conn, option.schemaName);
		
		
		enforceMatTxt.addPostAction(nodePlaceL2);
		
		actions.add(enforceMatTxt);		
		return actions;
	}
}
