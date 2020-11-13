package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckPayord;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckPayordem;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodeCusparL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodePayordemL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodePlaceL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipNodeSetuparL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckPlace;

public final class RootOrdmoipPlace extends DeciTreeTemplateWriteV2<OrdmoipInfo> {
	
	public RootOrdmoipPlace(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OrdmoipInfo> buildCheckerHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ModelCheckerV1<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OrdmoipInfo> checker;	
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStdV1<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<OrdmoipInfo> nodePayordist = new NodeOrdmoipPayordistL1(option).toAction();	
		ActionLazy<OrdmoipInfo> nodePayordem = new LazyOrdmoipNodePayordemL1(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> nodeCuspar = new LazyOrdmoipNodeCusparL1(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> nodeSetupar = new LazyOrdmoipNodeSetuparL1(option.conn, option.schemaName);		
		ActionLazy<OrdmoipInfo> nodeL1 = new LazyOrdmoipNodePlaceL1(option.conn, option.schemaName);	
		
		nodePayordist.addPostAction(nodePayordem);
		nodePayordem.addPostAction(nodeCuspar);
		nodeCuspar.addPostAction(nodeSetupar);
		nodeSetupar.addPostAction(nodeL1);
		
		actions.add(nodePayordist);		
		return actions;
	}
}
