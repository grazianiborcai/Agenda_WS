package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.LazyTokemoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.LazyTokemoipGenerate;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.LazyTokemoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.LazyTokemoipMergeSysEnviron;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.StdTokemoipMergeSyspar;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker.TokemoipCheckSetupar;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker.TokemoipCheckSyspar;

public final class NodeTokemoipGenerate extends DeciTreeWriteTemplate<TokemoipInfo> {
	
	public NodeTokemoipGenerate(DeciTreeOption<TokemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<TokemoipInfo> buildCheckerHook(DeciTreeOption<TokemoipInfo> option) {
		List<ModelChecker<TokemoipInfo>> queue = new ArrayList<>();		
		ModelChecker<TokemoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new TokemoipCheckSetupar(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new TokemoipCheckSyspar(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<TokemoipInfo>> buildActionsOnPassedHook(DeciTreeOption<TokemoipInfo> option) {
		List<ActionStdV1<TokemoipInfo>> actions = new ArrayList<>();		

		ActionStdV1<TokemoipInfo> mergeSyspar = new StdTokemoipMergeSyspar(option);	
		ActionLazyV1<TokemoipInfo> mergeSetupar = new LazyTokemoipMergeSetupar(option.conn, option.schemaName);
		ActionLazyV1<TokemoipInfo> mergeSysEnviron = new LazyTokemoipMergeSysEnviron(option.conn, option.schemaName);
		ActionLazyV1<TokemoipInfo> enforceSetup = new LazyTokemoipEnforceSetup(option.conn, option.schemaName);
		ActionLazyV1<TokemoipInfo> generateToken = new LazyTokemoipGenerate(option.conn, option.schemaName);
		
		mergeSyspar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(mergeSysEnviron);
		mergeSysEnviron.addPostAction(enforceSetup);
		enforceSetup.addPostAction(generateToken);
		
		actions.add(mergeSyspar);		
		return actions;
	}
}
