package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipRead;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.StdMultmoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.checker.MultmoipCheckRead;

public final class RootMultmoipRead extends DeciTreeTemplateWrite<MultmoipInfo> {
	
	public RootMultmoipRead(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MultmoipInfo> buildCheckerHook(DeciTreeOption<MultmoipInfo> option) {				
		List<ModelChecker<MultmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<MultmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new MultmoipCheckRead(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MultmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<MultmoipInfo> option) {
		List<ActionStd<MultmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<MultmoipInfo> enforcePaypar = new StdMultmoipEnforcePaypar(option);
		ActionLazy<MultmoipInfo> mergeSetupar = new LazyMultmoipMergeSetupar(option.conn, option.schemaName);	
		ActionLazy<MultmoipInfo> mergeSysenv = new LazyMultmoipMergeSysenv(option.conn, option.schemaName);	
		ActionLazy<MultmoipInfo> enforceSetup = new LazyMultmoipEnforceSetup(option.conn, option.schemaName);		
		ActionLazy<MultmoipInfo> read = new LazyMultmoipRead(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> enforceResponseAttr = new LazyMultmoipEnforceResponseAttr(option.conn, option.schemaName);
		
		enforcePaypar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		enforceSetup.addPostAction(read);
		read.addPostAction(enforceResponseAttr);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
