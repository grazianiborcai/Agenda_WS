package br.com.gda.payment.partnerMoip.refundMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.gda.payment.partnerMoip.refundMoip.model.action.LazyRefumoipEnforceResponseAttr;
import br.com.gda.payment.partnerMoip.refundMoip.model.action.LazyRefumoipEnforceSetup;
import br.com.gda.payment.partnerMoip.refundMoip.model.action.LazyRefumoipRefund;
import br.com.gda.payment.partnerMoip.refundMoip.model.action.StdRefumoipMergeSetupar;
import br.com.gda.payment.partnerMoip.refundMoip.model.checker.RefumoipCheckCuspar;
import br.com.gda.payment.partnerMoip.refundMoip.model.checker.RefumoipCheckCusparData;
import br.com.gda.payment.partnerMoip.refundMoip.model.checker.RefumoipCheckRead;

public final class RootRefumoipRefund extends DeciTreeWriteTemplate<RefumoipInfo> {
	
	public RootRefumoipRefund(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefumoipInfo> buildDecisionCheckerHook(DeciTreeOption<RefumoipInfo> option) {		
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<RefumoipInfo>> queue = new ArrayList<>();		
		ModelChecker<RefumoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new RefumoipCheckRead();
		queue.add(checker);
		
		checker = new RefumoipCheckCusparData();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new RefumoipCheckCuspar(checkerOption);
		queue.add(checker);
		//TODO: verificar partner = MOIP
		return new ModelCheckerQueue<>(queue);
	}
	
	
	//TODO: verificar refund duas vezes
	@Override protected List<ActionStd<RefumoipInfo>> buildActionsOnPassedHook(DeciTreeOption<RefumoipInfo> option) {
		List<ActionStd<RefumoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<RefumoipInfo> mergeSetupar = new StdRefumoipMergeSetupar(option);	
		ActionLazy<RefumoipInfo> enforceSetup = new LazyRefumoipEnforceSetup(option.conn, option.schemaName);		
		ActionLazy<RefumoipInfo> refund = new LazyRefumoipRefund(option.conn, option.schemaName);
		ActionLazy<RefumoipInfo> enforceResponseAttr = new LazyRefumoipEnforceResponseAttr(option.conn, option.schemaName);
		
		mergeSetupar.addPostAction(enforceSetup);
		enforceSetup.addPostAction(refund);
		refund.addPostAction(enforceResponseAttr);
		
		actions.add(mergeSetupar);		
		return actions;
	}
}
