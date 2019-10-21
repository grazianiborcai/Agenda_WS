package br.com.mind5.payment.partnerMoip.tokenMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.mind5.payment.partnerMoip.tokenMoip.model.action.LazyTokemoipEnforceSetup;
import br.com.mind5.payment.partnerMoip.tokenMoip.model.action.LazyTokemoipGenerate;
import br.com.mind5.payment.partnerMoip.tokenMoip.model.action.LazyTokemoipMergeSetupar;
import br.com.mind5.payment.partnerMoip.tokenMoip.model.action.LazyTokemoipMergeSysEnviron;
import br.com.mind5.payment.partnerMoip.tokenMoip.model.action.StdTokemoipMergeSyspar;
import br.com.mind5.payment.partnerMoip.tokenMoip.model.checker.TokemoipCheckSetupar;
import br.com.mind5.payment.partnerMoip.tokenMoip.model.checker.TokemoipCheckSyspar;

public final class NodeTokemoipGenerate extends DeciTreeWriteTemplate<TokemoipInfo> {
	
	public NodeTokemoipGenerate(DeciTreeOption<TokemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<TokemoipInfo> buildDecisionCheckerHook(DeciTreeOption<TokemoipInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<TokemoipInfo>> queue = new ArrayList<>();		
		ModelChecker<TokemoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new TokemoipCheckSetupar(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new TokemoipCheckSyspar(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<TokemoipInfo>> buildActionsOnPassedHook(DeciTreeOption<TokemoipInfo> option) {
		List<ActionStd<TokemoipInfo>> actions = new ArrayList<>();		

		ActionStd<TokemoipInfo> mergeSyspar = new StdTokemoipMergeSyspar(option);	
		ActionLazy<TokemoipInfo> mergeSetupar = new LazyTokemoipMergeSetupar(option.conn, option.schemaName);
		ActionLazy<TokemoipInfo> mergeSysEnviron = new LazyTokemoipMergeSysEnviron(option.conn, option.schemaName);
		ActionLazy<TokemoipInfo> enforceSetup = new LazyTokemoipEnforceSetup(option.conn, option.schemaName);
		ActionLazy<TokemoipInfo> generateToken = new LazyTokemoipGenerate(option.conn, option.schemaName);
		
		mergeSyspar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(mergeSysEnviron);
		mergeSysEnviron.addPostAction(enforceSetup);
		enforceSetup.addPostAction(generateToken);
		
		actions.add(mergeSyspar);		
		return actions;
	}
}
