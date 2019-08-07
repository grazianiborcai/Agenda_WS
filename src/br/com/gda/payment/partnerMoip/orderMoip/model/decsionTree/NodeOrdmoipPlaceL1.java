package br.com.gda.payment.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckCusparData;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckIsFee;

public final class NodeOrdmoipPlaceL1 extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public NodeOrdmoipPlaceL1(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildDecisionCheckerHook(DeciTreeOption<OrdmoipInfo> option) {		
		final boolean IS_FEE = true;
		
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrdmoipCheckCusparData();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = IS_FEE;	
		checker = new OrdmoipCheckIsFee(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> placeFee = new NodeOrdmoipPlaceFee(option).toAction();
		
		actions.add(placeFee);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnFailedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> placeMat = new NodeOrdmoipPlaceMat(option).toAction();
		
		actions.add(placeMat);		
		return actions;
	}
}
