package br.com.mind5.payment.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipNodePlaceL2;
import br.com.mind5.payment.partnerMoip.orderMoip.model.action.StdOrdmoipEnforceFeeTxt;
import br.com.mind5.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckSyspar;
import br.com.mind5.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckSysparData;
import br.com.mind5.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckWriteFee;

public final class NodeOrdmoipPlaceFee extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public NodeOrdmoipPlaceFee(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildDecisionCheckerHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new OrdmoipCheckWriteFee(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdmoipCheckSysparData(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdmoipCheckSyspar(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {		
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> enforceFeeTxt = new StdOrdmoipEnforceFeeTxt(option);	
		ActionLazy<OrdmoipInfo> nodeCreateL2 = new LazyOrdmoipNodePlaceL2(option.conn, option.schemaName);
		
		
		enforceFeeTxt.addPostAction(nodeCreateL2);
		
		actions.add(enforceFeeTxt);		
		return actions;
	}
}
