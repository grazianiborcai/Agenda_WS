package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipRead;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.StdOrdmoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckRead;

public final class RootOrdmoipRead extends DeciTreeTemplateWrite<OrdmoipInfo> {
	
	public RootOrdmoipRead(DeciTreeOption<OrdmoipInfo> option) {
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
		checker = new OrdmoipCheckRead(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> enforcePaypar = new StdOrdmoipEnforcePaypar(option);	
		ActionLazy<OrdmoipInfo> mergeSetupar = new LazyOrdmoipMergeSetupar(option.conn, option.schemaName);	
		ActionLazy<OrdmoipInfo> mergeSysenv = new LazyOrdmoipMergeSysenv(option.conn, option.schemaName);	
		ActionLazy<OrdmoipInfo> enforceSetup = new LazyOrdmoipEnforceSetup(option.conn, option.schemaName);		
		ActionLazy<OrdmoipInfo> read = new LazyOrdmoipRead(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceResponseAttr = new LazyOrdmoipEnforceResponseAttr(option.conn, option.schemaName);
		
		enforcePaypar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		enforceSetup.addPostAction(read);
		read.addPostAction(enforceResponseAttr);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
