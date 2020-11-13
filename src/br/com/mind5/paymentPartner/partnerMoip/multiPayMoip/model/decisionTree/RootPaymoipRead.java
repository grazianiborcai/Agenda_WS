package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipRead;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.StdPaymoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.checker.PaymoipCheckRead;

public final class RootPaymoipRead extends DeciTreeTemplateWrite<PaymoipInfo> {
	
	public RootPaymoipRead(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaymoipInfo> buildCheckerHook(DeciTreeOption<PaymoipInfo> option) {	
		List<ModelChecker<PaymoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PaymoipInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaymoipCheckRead(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaymoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymoipInfo> option) {
		List<ActionStd<PaymoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<PaymoipInfo> enforcePaypar = new StdPaymoipEnforcePaypar(option);
		ActionLazy<PaymoipInfo> mergeSysenv = new LazyPaymoipMergeSysenv(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> mergeSetupar = new LazyPaymoipMergeSetupar(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> enforceSetup = new LazyPaymoipEnforceSetup(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> read = new LazyPaymoipRead(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> enforceReponseAttr = new LazyPaymoipEnforceResponseAttr(option.conn, option.schemaName);
		
		enforcePaypar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(enforceSetup);
		enforceSetup.addPostAction(read);
		read.addPostAction(enforceReponseAttr);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
