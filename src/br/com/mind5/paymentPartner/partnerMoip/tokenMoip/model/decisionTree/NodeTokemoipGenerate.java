package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.LazyTokemoipEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.LazyTokemoipGenerate;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.LazyTokemoipMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.LazyTokemoipMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.StdTokemoipMergeSyspar;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker.TokemoipCheckSetupar;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker.TokemoipCheckSyspar;

public final class NodeTokemoipGenerate extends DeciTreeTemplateWriteV2<TokemoipInfo> {
	
	public NodeTokemoipGenerate(DeciTreeOption<TokemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<TokemoipInfo> buildCheckerHook(DeciTreeOption<TokemoipInfo> option) {
		List<ModelCheckerV1<TokemoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<TokemoipInfo> checker;	
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

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<TokemoipInfo>> buildActionsOnPassedHook(DeciTreeOption<TokemoipInfo> option) {
		List<ActionStdV2<TokemoipInfo>> actions = new ArrayList<>();		

		ActionStdV2<TokemoipInfo> mergeSyspar = new StdTokemoipMergeSyspar(option);	
		ActionLazy<TokemoipInfo> mergeSetupar = new LazyTokemoipMergeSetupar(option.conn, option.schemaName);
		ActionLazy<TokemoipInfo> mergeSysenv = new LazyTokemoipMergeSysenv(option.conn, option.schemaName);
		ActionLazy<TokemoipInfo> enforceSetup = new LazyTokemoipEnforceSetup(option.conn, option.schemaName);
		ActionLazy<TokemoipInfo> generateToken = new LazyTokemoipGenerate(option.conn, option.schemaName);
		
		mergeSyspar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		enforceSetup.addPostAction(generateToken);
		
		actions.add(mergeSyspar);		
		return actions;
	}
}
