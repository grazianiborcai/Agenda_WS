package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckIsFee;

public final class NodeOrdmoipPlaceL1 extends DeciTreeTemplateWriteV2<OrdmoipInfo> {
	
	public NodeOrdmoipPlaceL1(DeciTreeOption<OrdmoipInfo> option) {
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
		checker = new OrdmoipCheckIsFee(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStdV2<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV2<OrdmoipInfo> placeFee = new NodeOrdmoipPlaceFee(option).toAction();
		
		actions.add(placeFee);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<OrdmoipInfo>> buildActionsOnFailedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStdV2<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV2<OrdmoipInfo> placeMat = new NodeOrdmoipPlaceMat(option).toAction();
		
		actions.add(placeMat);		
		return actions;
	}
}
