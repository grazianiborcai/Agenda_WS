package br.com.gda.payment.partnerMoip.multiOrderMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.action.LazyMultmoipCreate;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.action.LazyMultmoipEnforceMultiorder;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.action.LazyMultmoipEnforceResponseAttr;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.action.LazyMultmoipEnforceResponseOrdmoip;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.action.LazyMultmoipEnforceSetup;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.action.LazyMultmoipMergeSetupar;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.action.StdMultmoipOrdmoipPlace;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.checker.MultmoipCheckPay;

public final class NodeMultmoipPlace extends DeciTreeReadTemplate<MultmoipInfo> {
	
	public NodeMultmoipPlace(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MultmoipInfo> buildDecisionCheckerHook(DeciTreeOption<MultmoipInfo> option) {	
		List<ModelChecker<MultmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<MultmoipInfo> checker;
		
		checker = new MultmoipCheckPay();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MultmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<MultmoipInfo> option) {
		List<ActionStd<MultmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<MultmoipInfo> placeOrdmoip = new StdMultmoipOrdmoipPlace(option);
		ActionLazy<MultmoipInfo> enforceMultiorder = new LazyMultmoipEnforceMultiorder(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> mergeSetupar = new LazyMultmoipMergeSetupar(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> enforceSetup = new LazyMultmoipEnforceSetup(option.conn, option.schemaName);		
		ActionLazy<MultmoipInfo> create = new LazyMultmoipCreate(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> enforceResponseAttr = new LazyMultmoipEnforceResponseAttr(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> enforceResponseOrdmoip = new LazyMultmoipEnforceResponseOrdmoip(option.conn, option.schemaName);
		
		placeOrdmoip.addPostAction(enforceMultiorder);		
		enforceMultiorder.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(enforceSetup);
		enforceSetup.addPostAction(create);
		create.addPostAction(enforceResponseAttr);
		enforceResponseAttr.addPostAction(enforceResponseOrdmoip);
		
		actions.add(placeOrdmoip);		
		return actions;
	}
}
