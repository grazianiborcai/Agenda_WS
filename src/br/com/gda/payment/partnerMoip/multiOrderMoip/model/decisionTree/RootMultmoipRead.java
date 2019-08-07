package br.com.gda.payment.partnerMoip.multiOrderMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.action.LazyMultmoipEnforceResponseAttr;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.action.LazyMultmoipEnforceSetup;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.action.LazyMultmoipMergeSysEnviron;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.action.LazyMultmoipRead;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.action.StdMultmoipMergeSetupar;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.checker.MultmoipCheckCuspar;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.checker.MultmoipCheckCusparData;
import br.com.gda.payment.partnerMoip.multiOrderMoip.model.checker.MultmoipCheckRead;

public final class RootMultmoipRead extends DeciTreeWriteTemplate<MultmoipInfo> {
	
	public RootMultmoipRead(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MultmoipInfo> buildDecisionCheckerHook(DeciTreeOption<MultmoipInfo> option) {		
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<MultmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<MultmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new MultmoipCheckRead();
		queue.add(checker);
		
		checker = new MultmoipCheckCusparData();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MultmoipCheckCuspar(checkerOption);
		queue.add(checker);
		//TODO: verificar partner = MOIP
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MultmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<MultmoipInfo> option) {
		List<ActionStd<MultmoipInfo>> actions = new ArrayList<>();	
		
		ActionStd<MultmoipInfo> mergeSetupar = new StdMultmoipMergeSetupar(option);	
		ActionLazy<MultmoipInfo> mergeSysEnviron = new LazyMultmoipMergeSysEnviron(option.conn, option.schemaName);	
		ActionLazy<MultmoipInfo> enforceSetup = new LazyMultmoipEnforceSetup(option.conn, option.schemaName);		
		ActionLazy<MultmoipInfo> read = new LazyMultmoipRead(option.conn, option.schemaName);
		ActionLazy<MultmoipInfo> enforceResponseAttr = new LazyMultmoipEnforceResponseAttr(option.conn, option.schemaName);
		
		mergeSetupar.addPostAction(mergeSysEnviron);
		mergeSysEnviron.addPostAction(enforceSetup);
		enforceSetup.addPostAction(read);
		read.addPostAction(enforceResponseAttr);
		
		actions.add(mergeSetupar);		
		return actions;
	}
}
