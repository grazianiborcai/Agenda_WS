package br.com.gda.payment.partnerMoip.accessMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.gda.payment.partnerMoip.accessMoip.model.action.LazyAccemoipEnforceObfuscate;
import br.com.gda.payment.partnerMoip.accessMoip.model.action.LazyAccemoipEnforceScopes;
import br.com.gda.payment.partnerMoip.accessMoip.model.action.LazyAccemoipEnforceSetup;
import br.com.gda.payment.partnerMoip.accessMoip.model.action.LazyAccemoipInsertPeresmoip;
import br.com.gda.payment.partnerMoip.accessMoip.model.action.LazyAccemoipMergeSetupar;
import br.com.gda.payment.partnerMoip.accessMoip.model.action.LazyAccemoipMergeSysEnviron;
import br.com.gda.payment.partnerMoip.accessMoip.model.action.LazyAccemoipUrl;
import br.com.gda.payment.partnerMoip.accessMoip.model.action.StdAccemoipMergeSyspar;
import br.com.gda.payment.partnerMoip.accessMoip.model.checker.AccemoipCheckSetupar;
import br.com.gda.payment.partnerMoip.accessMoip.model.checker.AccemoipCheckSyspar;

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
	
	
	
	@Override protected List<ActionStd<AccemoipInfo>> buildActionsOnPassedHook(DeciTreeOption<AccemoipInfo> option) {
		List<ActionStd<AccemoipInfo>> actions = new ArrayList<>();		

		ActionStd<AccemoipInfo> mergeSyspar = new StdAccemoipMergeSyspar(option);	
		ActionLazy<AccemoipInfo> mergeSetupar = new LazyAccemoipMergeSetupar(option.conn, option.schemaName);
		ActionLazy<AccemoipInfo> mergeSysEnviron = new LazyAccemoipMergeSysEnviron(option.conn, option.schemaName);
		ActionLazy<AccemoipInfo> enforceSetup = new LazyAccemoipEnforceSetup(option.conn, option.schemaName);		
		ActionLazy<AccemoipInfo> enforceScopes = new LazyAccemoipEnforceScopes(option.conn, option.schemaName);
		ActionLazy<AccemoipInfo> enforceUrl = new LazyAccemoipUrl(option.conn, option.schemaName);
		ActionLazy<AccemoipInfo> insertPeresmoip = new LazyAccemoipInsertPeresmoip(option.conn, option.schemaName);
		ActionLazy<AccemoipInfo> obfuscate = new LazyAccemoipEnforceObfuscate(option.conn, option.schemaName);
		
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
