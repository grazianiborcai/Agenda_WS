package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipCreate;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipEnforceOwnId;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipEnforceResponseOrdmoip;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.LazyMultmoipMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action.StdMultmoipEnforceMultiorder;

public final class NodeMultmoipPlace extends DeciTreeTemplateReadV2<MultmoipInfo> {
	
	public NodeMultmoipPlace(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MultmoipInfo> buildCheckerHook(DeciTreeOption<MultmoipInfo> option) {	
		List<ModelCheckerV1<MultmoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MultmoipInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MultmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<MultmoipInfo> option) {
		List<ActionStdV1<MultmoipInfo>> actions = new ArrayList<>();			
		
		ActionStdV1<MultmoipInfo> enforceMultiorder = new StdMultmoipEnforceMultiorder(option);		
		ActionLazy<MultmoipInfo> enforcePaypar = new LazyMultmoipEnforcePaypar(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> mergeSetupar = new LazyMultmoipMergeSetupar(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> mergeSysenv = new LazyMultmoipMergeSysenv(option.conn, option.schemaName);	
		ActionLazy<MultmoipInfo> enforceSetup = new LazyMultmoipEnforceSetup(option.conn, option.schemaName);	
		ActionLazy<MultmoipInfo> enforceOwnId = new LazyMultmoipEnforceOwnId(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> create = new LazyMultmoipCreate(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> enforceResponseAttr = new LazyMultmoipEnforceResponseAttr(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> enforceResponseOrdmoip = new LazyMultmoipEnforceResponseOrdmoip(option.conn, option.schemaName);
			
		enforceMultiorder.addPostAction(enforcePaypar);
		enforcePaypar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		enforceSetup.addPostAction(enforceOwnId);
		enforceOwnId.addPostAction(create);
		create.addPostAction(enforceResponseAttr);
		enforceResponseAttr.addPostAction(enforceResponseOrdmoip);
		
		actions.add(enforceMultiorder);		
		return actions;
	}
}
