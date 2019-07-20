package br.com.gda.payment.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipNodePlaceL2;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.StdOrdmoipEnforceFeeTxt;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckSyspar;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckSysparData;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckWriteFee;

public final class NodeOrdmoipPlaceFee extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public NodeOrdmoipPlaceFee(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildDecisionCheckerHook(DeciTreeOption<OrdmoipInfo> option) {		
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrdmoipCheckWriteFee();
		queue.add(checker);
		
		checker = new OrdmoipCheckSysparData();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdmoipCheckSyspar(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> enforceFeeTxt = new StdOrdmoipEnforceFeeTxt(option);	
		ActionLazy<OrdmoipInfo> nodeCreateL2 = new LazyOrdmoipNodePlaceL2(option.conn, option.schemaName);
		
		
		enforceFeeTxt.addPostAction(nodeCreateL2);
		
		actions.add(enforceFeeTxt);		
		return actions;
	}
}
