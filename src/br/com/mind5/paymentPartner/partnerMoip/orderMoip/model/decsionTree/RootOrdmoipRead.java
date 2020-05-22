package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.LazyOrdmoipRead;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action.StdOrdmoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.checker.OrdmoipCheckRead;

public final class RootOrdmoipRead extends DeciTreeTemplateWriteV2<OrdmoipInfo> {
	
	public RootOrdmoipRead(DeciTreeOption<OrdmoipInfo> option) {
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
		checker = new OrdmoipCheckRead(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStdV1<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<OrdmoipInfo> enforcePaypar = new StdOrdmoipEnforcePaypar(option);	
		ActionLazyV1<OrdmoipInfo> mergeSetupar = new LazyOrdmoipMergeSetupar(option.conn, option.schemaName);	
		ActionLazyV1<OrdmoipInfo> mergeSysenv = new LazyOrdmoipMergeSysenv(option.conn, option.schemaName);	
		ActionLazyV1<OrdmoipInfo> enforceSetup = new LazyOrdmoipEnforceSetup(option.conn, option.schemaName);		
		ActionLazyV1<OrdmoipInfo> read = new LazyOrdmoipRead(option.conn, option.schemaName);
		ActionLazyV1<OrdmoipInfo> enforceResponseAttr = new LazyOrdmoipEnforceResponseAttr(option.conn, option.schemaName);
		
		enforcePaypar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		enforceSetup.addPostAction(read);
		read.addPostAction(enforceResponseAttr);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
