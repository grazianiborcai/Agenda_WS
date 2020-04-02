package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipEnforceObfuscate;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipEnforceScopes;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipInsertPeresmoip;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipMergeSysEnviron;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipUrl;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.StdAccemoipMergeSyspar;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckSetupar;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckSyspar;

public final class NodeAccemoipUrl extends DeciTreeWriteTemplate<AccemoipInfo> {
	
	public NodeAccemoipUrl(DeciTreeOption<AccemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AccemoipInfo> buildDecisionCheckerHook(DeciTreeOption<AccemoipInfo> option) {
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

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AccemoipInfo>> buildActionsOnPassedHook(DeciTreeOption<AccemoipInfo> option) {
		List<ActionStdV1<AccemoipInfo>> actions = new ArrayList<>();		

		ActionStdV1<AccemoipInfo> mergeSyspar = new StdAccemoipMergeSyspar(option);	
		ActionLazyV1<AccemoipInfo> mergeSetupar = new LazyAccemoipMergeSetupar(option.conn, option.schemaName);
		ActionLazyV1<AccemoipInfo> mergeSysEnviron = new LazyAccemoipMergeSysEnviron(option.conn, option.schemaName);
		ActionLazyV1<AccemoipInfo> enforceSetup = new LazyAccemoipEnforceSetup(option.conn, option.schemaName);		
		ActionLazyV1<AccemoipInfo> enforceScopes = new LazyAccemoipEnforceScopes(option.conn, option.schemaName);
		ActionLazyV1<AccemoipInfo> enforceUrl = new LazyAccemoipUrl(option.conn, option.schemaName);
		ActionLazyV1<AccemoipInfo> insertPeresmoip = new LazyAccemoipInsertPeresmoip(option.conn, option.schemaName);
		ActionLazyV1<AccemoipInfo> obfuscate = new LazyAccemoipEnforceObfuscate(option.conn, option.schemaName);
		
		mergeSyspar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(mergeSysEnviron);
		mergeSysEnviron.addPostAction(enforceSetup);		
		enforceSetup.addPostAction(enforceScopes);
		enforceScopes.addPostAction(enforceUrl);
		enforceUrl.addPostAction(insertPeresmoip);
		insertPeresmoip.addPostAction(obfuscate);
		
		actions.add(mergeSyspar);		
		return actions;
	}
}
