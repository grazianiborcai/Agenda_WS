package br.com.mind5.payment.partnerMoip.multiPayMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceResponseAttr;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.action.LazyPaymoipEnforceSetup;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.action.LazyPaymoipMergeSetupar;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.action.LazyPaymoipRead;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.action.StdPaymoipMergeSysEnviron;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.check.PaymoipCheckCuspar;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.check.PaymoipCheckCusparData;
import br.com.mind5.payment.partnerMoip.multiPayMoip.model.check.PaymoipCheckRead;

public final class RootPaymoipRead extends DeciTreeWriteTemplate<PaymoipInfo> {
	
	public RootPaymoipRead(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PaymoipInfo> buildDecisionCheckerHook(DeciTreeOption<PaymoipInfo> option) {	
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PaymoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PaymoipInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new PaymoipCheckRead();
		queue.add(checker);
		
		checker = new PaymoipCheckCusparData();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PaymoipCheckCuspar(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PaymoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymoipInfo> option) {
		List<ActionStd<PaymoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<PaymoipInfo> mergeSysEnviron = new StdPaymoipMergeSysEnviron(option);
		ActionLazy<PaymoipInfo> mergeSetupar = new LazyPaymoipMergeSetupar(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> enforceSetup = new LazyPaymoipEnforceSetup(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> read = new LazyPaymoipRead(option.conn, option.schemaName);
		ActionLazy<PaymoipInfo> enforceReponseAttr = new LazyPaymoipEnforceResponseAttr(option.conn, option.schemaName);
		
		mergeSysEnviron.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(enforceSetup);
		enforceSetup.addPostAction(read);
		read.addPostAction(enforceReponseAttr);
		
		actions.add(mergeSysEnviron);		
		return actions;
	}
}
