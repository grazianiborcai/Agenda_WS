package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.TokemoipVisiEnforceSetup;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.TokemoipVisiGenerate;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.TokemoipVisiMergeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.TokemoipVisiMergeSysenv;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.TokemoipVisiMergeSyspar;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker.TokemoipCheckSetupar;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker.TokemoipCheckSyspar;

public final class TokemoipNodeGenerate extends DeciTreeTemplateWrite<TokemoipInfo> {
	
	public TokemoipNodeGenerate(DeciTreeOption<TokemoipInfo> option) {
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

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<TokemoipInfo>> buildActionsOnPassedHook(DeciTreeOption<TokemoipInfo> option) {
		List<ActionStd<TokemoipInfo>> actions = new ArrayList<>();		

		ActionStd<TokemoipInfo> mergeSyspar = new ActionStdCommom<TokemoipInfo>(option, TokemoipVisiMergeSyspar.class);	
		ActionLazy<TokemoipInfo> mergeSetupar = new ActionLazyCommom<TokemoipInfo>(option, TokemoipVisiMergeSetupar.class);
		ActionLazy<TokemoipInfo> mergeSysenv = new ActionLazyCommom<TokemoipInfo>(option, TokemoipVisiMergeSysenv.class);
		ActionLazy<TokemoipInfo> enforceSetup = new ActionLazyCommom<TokemoipInfo>(option, TokemoipVisiEnforceSetup.class);
		ActionLazy<TokemoipInfo> generateToken = new ActionLazyCommom<TokemoipInfo>(option, TokemoipVisiGenerate.class);
		
		mergeSyspar.addPostAction(mergeSetupar);
		mergeSetupar.addPostAction(mergeSysenv);
		mergeSysenv.addPostAction(enforceSetup);
		enforceSetup.addPostAction(generateToken);
		
		actions.add(mergeSyspar);		
		return actions;
	}
}
