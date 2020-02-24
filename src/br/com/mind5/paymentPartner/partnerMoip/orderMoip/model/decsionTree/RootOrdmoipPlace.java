package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckPayord;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckPayordem;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodeCusparL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodePayordemL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodePlaceL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodeSysparL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckPlace;

public final class RootOrdmoipPlace extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public RootOrdmoipPlace(DeciTreeOption<OrdmoipInfo> option) {
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
		checker = new OrdmoipCheckPlace(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdmoipCheckPayord(checkerOption);
		queue.add(checker);

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdmoipCheckPayordem(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> nodePayordist = new NodeOrdmoipPayordistL1(option).toAction();	
		ActionLazy<OrdmoipInfo> nodePayordem = new LazyOrdmoipNodePayordemL1(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> nodeCuspar = new LazyOrdmoipNodeCusparL1(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> nodeSyspar = new LazyOrdmoipNodeSysparL1(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> mergeSetupar = new LazyOrdmoipMergeSetupar(option.conn, option.schemaName);		
		ActionLazy<OrdmoipInfo> nodeL1 = new LazyOrdmoipNodePlaceL1(option.conn, option.schemaName);	
		
		nodePayordist.addPostAction(nodePayordem);
		nodePayordem.addPostAction(nodeCuspar);
		nodeCuspar.addPostAction(nodeSyspar);
		nodeSyspar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(nodeL1);
		
		actions.add(nodePayordist);		
		return actions;
	}
}
