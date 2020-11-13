package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipEnforceObfuscate;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipEnforceScopes;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipPeresmoipInsert;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipUrl;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.StdAccemoipMergeSyspar;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckSetupar;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckSyspar;

public final class NodeAccemoipUrl extends DeciTreeTemplateWrite<AccemoipInfo> {
	
	public NodeAccemoipUrl(DeciTreeOption<AccemoipInfo> option) {
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

		ActionStd<AccemoipInfo> mergeSyspar = new StdAccemoipMergeSyspar(option);	
		ActionLazy<AccemoipInfo> mergeSetupar = new LazyAccemoipMergeSetupar(option.conn, option.schemaName);
		ActionLazy<AccemoipInfo> mergeSysenv = new LazyAccemoipMergeSysenv(option.conn, option.schemaName);
		ActionLazy<AccemoipInfo> enforceSetup = new LazyAccemoipEnforceSetup(option.conn, option.schemaName);		
		ActionLazy<AccemoipInfo> enforceScopes = new LazyAccemoipEnforceScopes(option.conn, option.schemaName);
		ActionLazy<AccemoipInfo> enforceUrl = new LazyAccemoipUrl(option.conn, option.schemaName);
		ActionLazy<AccemoipInfo> insertPeresmoip = new LazyAccemoipPeresmoipInsert(option.conn, option.schemaName);
		ActionLazy<AccemoipInfo> obfuscate = new LazyAccemoipEnforceObfuscate(option.conn, option.schemaName);
		
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
