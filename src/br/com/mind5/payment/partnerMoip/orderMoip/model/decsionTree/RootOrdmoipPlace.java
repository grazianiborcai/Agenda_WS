package br.com.mind5.payment.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckCuspar;
import br.com.mind5.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckCusparData;
import br.com.mind5.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckPlace;

public final class RootOrdmoipPlace extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public RootOrdmoipPlace(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildDecisionCheckerHook(DeciTreeOption<OrdmoipInfo> option) {		
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrdmoipCheckPlace();
		queue.add(checker);
		
		checker = new OrdmoipCheckCusparData();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdmoipCheckCuspar(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> nodePlaceL1 = new NodeOrdmoipPlaceL1(option).toAction();	
		
		actions.add(nodePlaceL1);		
		return actions;
	}
}
