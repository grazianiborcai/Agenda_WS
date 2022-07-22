package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiNodeCusparL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiNodePayordemL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiNodePlaceL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.OrdmoipVisiNodeSetuparL1;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckPayord;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckPayordem;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckPlace;

public final class OrdmoipRootPlace extends DeciTreeTemplateWrite<OrdmoipInfo> {
	
	public OrdmoipRootPlace(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildCheckerHook(DeciTreeOption<OrdmoipInfo> option) {
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> nodePayordist = new OrdmoipNodePayordistL1(option).toAction();	
		ActionLazy<OrdmoipInfo> nodePayordem = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiNodePayordemL1.class);
		ActionLazy<OrdmoipInfo> nodeCuspar = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiNodeCusparL1.class);
		ActionLazy<OrdmoipInfo> nodeSetupar = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiNodeSetuparL1.class);		
		ActionLazy<OrdmoipInfo> nodeL1 = new ActionLazyCommom<OrdmoipInfo>(option, OrdmoipVisiNodePlaceL1.class);	
		
		nodePayordist.addPostAction(nodePayordem);
		nodePayordem.addPostAction(nodeCuspar);
		nodeCuspar.addPostAction(nodeSetupar);
		nodeSetupar.addPostAction(nodeL1);
		
		actions.add(nodePayordist);		
		return actions;
	}
}
