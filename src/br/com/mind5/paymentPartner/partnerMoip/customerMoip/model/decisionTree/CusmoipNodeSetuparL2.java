package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.CusmoipVisiEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.CusmoipVisiMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.CusmoipVisiMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker.CusmoipCheckSetupar;

public final class CusmoipNodeSetuparL2 extends DeciTreeTemplateWrite<CusmoipInfo> {
	
	public CusmoipNodeSetuparL2(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusmoipInfo> buildCheckerHook(DeciTreeOption<CusmoipInfo> option) {
		List<ModelChecker<CusmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CusmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusmoipCheckSetupar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CusmoipInfo> option) {
		List<ActionStd<CusmoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CusmoipInfo> mergeSetupar = new ActionStdCommom<CusmoipInfo>(option, CusmoipVisiMergeSetupar.class);
		ActionLazy<CusmoipInfo> mergeSysenv = new ActionLazyCommom<CusmoipInfo>(option, CusmoipVisiMergeSysenv.class);
		ActionLazy<CusmoipInfo> enforceSetup = new ActionLazyCommom<CusmoipInfo>(option, CusmoipVisiEnforceSetup.class);
		
		mergeSetupar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
