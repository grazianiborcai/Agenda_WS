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
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckRead;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceResponseAttr;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipEnforceSetup;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipMergeSysEnviron;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.LazyOrdmoipRead;
import br.com.gda.payment.partnerMoip.orderMoip.model.action.StdOrdmoipMergeSetupar;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckCuspar;
import br.com.gda.payment.partnerMoip.orderMoip.model.checker.OrdmoipCheckCusparData;

public final class RootOrdmoipRead extends DeciTreeWriteTemplate<OrdmoipInfo> {
	
	public RootOrdmoipRead(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdmoipInfo> buildDecisionCheckerHook(DeciTreeOption<OrdmoipInfo> option) {		
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OrdmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new OrdmoipCheckRead();
		queue.add(checker);
		
		checker = new OrdmoipCheckCusparData();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new OrdmoipCheckCuspar(checkerOption);
		queue.add(checker);
		//TODO: verificar partner = MOIP
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdmoipInfo> option) {
		List<ActionStd<OrdmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<OrdmoipInfo> mergeSetupar = new StdOrdmoipMergeSetupar(option);	
		ActionLazy<OrdmoipInfo> mergeSysEnviron = new LazyOrdmoipMergeSysEnviron(option.conn, option.schemaName);	
		ActionLazy<OrdmoipInfo> enforceSetup = new LazyOrdmoipEnforceSetup(option.conn, option.schemaName);		
		ActionLazy<OrdmoipInfo> read = new LazyOrdmoipRead(option.conn, option.schemaName);
		ActionLazy<OrdmoipInfo> enforceResponseAttr = new LazyOrdmoipEnforceResponseAttr(option.conn, option.schemaName);
		
		mergeSetupar.addPostAction(mergeSysEnviron);
		mergeSysEnviron.addPostAction(enforceSetup);
		enforceSetup.addPostAction(read);
		read.addPostAction(enforceResponseAttr);
		
		actions.add(mergeSetupar);		
		return actions;
	}
}
