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
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.TokemoipVisiNodeGenerate;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action.TokemoipVisiEnforcePayPartner;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker.TokemoipCheckLangu;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker.TokemoipCheckOwner;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker.TokemoipCheckStorauth;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker.TokemoipCheckStore;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker.TokemoipCheckUsername;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.checker.TokemoipCheckWrite;

public final class TokemoipRootGenerate extends DeciTreeTemplateWrite<TokemoipInfo> {
	
	public TokemoipRootGenerate(DeciTreeOption<TokemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<TokemoipInfo> buildCheckerHook(DeciTreeOption<TokemoipInfo> option) {
		List<ModelChecker<TokemoipInfo>> queue = new ArrayList<>();		
		ModelChecker<TokemoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new TokemoipCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new TokemoipCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new TokemoipCheckUsername(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new TokemoipCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new TokemoipCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new TokemoipCheckStorauth(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<TokemoipInfo>> buildActionsOnPassedHook(DeciTreeOption<TokemoipInfo> option) {
		List<ActionStd<TokemoipInfo>> actions = new ArrayList<>();		

		ActionStd<TokemoipInfo> enforcePayPartner = new ActionStdCommom<TokemoipInfo>(option, TokemoipVisiEnforcePayPartner.class);	
		ActionLazy<TokemoipInfo> nodeGenerate = new ActionLazyCommom<TokemoipInfo>(option, TokemoipVisiNodeGenerate.class);
		
		enforcePayPartner.addPostAction(nodeGenerate);
		
		actions.add(enforcePayPartner);		
		return actions;
	}
}
