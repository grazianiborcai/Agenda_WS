package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.AccemoipVisiEnforceObfuscate;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.AccemoipVisiEnforceScopes;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.AccemoipVisiEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.AccemoipVisiMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.AccemoipVisiMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.AccemoipVisiMergeSyspar;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.AccemoipVisiPeresmoipInsert;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.AccemoipVisiUrl;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckSetupar;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckSyspar;

public final class AccemoipNodeUrl extends DeciTreeTemplateWrite<AccemoipInfo> {
	
	public AccemoipNodeUrl(DeciTreeOption<AccemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AccemoipInfo> buildCheckerHook(DeciTreeOption<AccemoipInfo> option) {
		List<ModelChecker<AccemoipInfo>> queue = new ArrayList<>();		
		ModelChecker<AccemoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AccemoipCheckSetupar(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AccemoipCheckSyspar(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AccemoipInfo>> buildActionsOnPassedHook(DeciTreeOption<AccemoipInfo> option) {
		List<ActionStd<AccemoipInfo>> actions = new ArrayList<>();		

		ActionStd<AccemoipInfo> mergeSyspar = new ActionStdCommom<AccemoipInfo>(option, AccemoipVisiMergeSyspar.class);	
		ActionLazy<AccemoipInfo> mergeSetupar = new ActionLazyCommom<AccemoipInfo>(option, AccemoipVisiMergeSetupar.class);
		ActionLazy<AccemoipInfo> mergeSysenv = new ActionLazyCommom<AccemoipInfo>(option, AccemoipVisiMergeSysenv.class);
		ActionLazy<AccemoipInfo> enforceSetup = new ActionLazyCommom<AccemoipInfo>(option, AccemoipVisiEnforceSetup.class);		
		ActionLazy<AccemoipInfo> enforceScopes = new ActionLazyCommom<AccemoipInfo>(option, AccemoipVisiEnforceScopes.class);
		ActionLazy<AccemoipInfo> enforceUrl = new ActionLazyCommom<AccemoipInfo>(option, AccemoipVisiUrl.class);
		ActionLazy<AccemoipInfo> insertPeresmoip = new ActionLazyCommom<AccemoipInfo>(option, AccemoipVisiPeresmoipInsert.class);
		ActionLazy<AccemoipInfo> obfuscate = new ActionLazyCommom<AccemoipInfo>(option, AccemoipVisiEnforceObfuscate.class);
		
		mergeSyspar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);		
		enforceSetup.addPostAction(enforceScopes);
		enforceScopes.addPostAction(enforceUrl);
		enforceUrl.addPostAction(insertPeresmoip);
		insertPeresmoip.addPostAction(obfuscate);
		
		actions.add(mergeSyspar);		
		return actions;
	}
}
