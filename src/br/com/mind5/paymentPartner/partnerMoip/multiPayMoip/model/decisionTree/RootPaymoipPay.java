package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipCard;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceCard;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceFunding;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforcePayment;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceResponseAttr;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipNodeCrecardL1;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipNodeSetuparL1;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.LazyPaymoipNodeSysparL1;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action.StdPaymoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.checker.PaymoipCheckPay;

public final class RootPaymoipPay extends DeciTreeTemplateWriteV2<PaymoipInfo> {
	
	public RootPaymoipPay(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PaymoipInfo> buildCheckerHook(DeciTreeOption<PaymoipInfo> option) {	
		List<ModelCheckerV1<PaymoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PaymoipInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new PaymoipCheckPay(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PaymoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymoipInfo> option) {
		List<ActionStdV1<PaymoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<PaymoipInfo> enforcePaypar = new StdPaymoipEnforcePaypar(option);
		ActionLazy<PaymoipInfo> nodeCrecard = new LazyPaymoipNodeCrecardL1(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> nodeSyspar = new LazyPaymoipNodeSysparL1(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> nodeSetupar = new LazyPaymoipNodeSetuparL1(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> enforceCard = new LazyPaymoipEnforceCard(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> enforceFunding = new LazyPaymoipEnforceFunding(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> enforcePayment = new LazyPaymoipEnforcePayment(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> mergeSysenv = new LazyPaymoipMergeSysenv(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> enforceSetup = new LazyPaymoipEnforceSetup(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> payWithCredicard = new LazyPaymoipCard(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> enforceReponseAttr = new LazyPaymoipEnforceResponseAttr(option.conn, option.schemaName);
		
		enforcePaypar.addPostAction(nodeCrecard);
		nodeCrecard.addPostAction(nodeSyspar);
		nodeSyspar.addPostAction(nodeSetupar);
		nodeSetupar.addPostAction(enforceCard);
		enforceCard.addPostAction(enforceFunding);
		enforceFunding.addPostAction(enforcePayment);
		enforcePayment.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		enforceSetup.addPostAction(payWithCredicard);
		payWithCredicard.addPostAction(enforceReponseAttr);
		
		actions.add(enforcePaypar);		
		return actions;
	}
}
