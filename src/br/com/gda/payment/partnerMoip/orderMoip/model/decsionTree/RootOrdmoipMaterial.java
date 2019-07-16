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
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipNodeMaterial;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.StdOrdmoipMergeStopar;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckCuspar;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckCusparData;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckMatData;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckPayordemData;

public final class RootOrdmoipMaterial extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public RootOrdmoipMaterial(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildDecisionCheckerHook(DeciTreeOption<OrdmoipInfo> option) {		
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrdmoipCheckPayordemData();
		queue.add(checker);
		
		checker = new OrdmoipCheckMatData();
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

		ActionStd<OrdmoipInfo> mergeStopar = new StdOrdmoipMergeStopar(option);	
		ActionLazy<OrdmoipInfo> nodeMaterial = new LazyOrdmoipNodeMaterial(option.conn, option.schemaName);	
		
		mergeStopar.addPostAction(nodeMaterial);
		
		actions.add(mergeStopar);		
		return actions;
	}
}
