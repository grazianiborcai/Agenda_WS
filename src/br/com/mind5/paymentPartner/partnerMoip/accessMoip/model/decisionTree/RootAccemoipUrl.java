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
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipNodeUrl;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.StdAccemoipEnforcePayPartner;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckLangu;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckOwner;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckStorauth;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckStore;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckUsername;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckWrite;

public final class RootAccemoipUrl extends DeciTreeTemplateWrite<AccemoipInfo> {
	
	public RootAccemoipUrl(DeciTreeOption<AccemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AccemoipInfo> buildCheckerHook(DeciTreeOption<AccemoipInfo> option) {
		List<ModelChecker<AccemoipInfo>> queue = new ArrayList<>();		
		ModelChecker<AccemoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AccemoipCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AccemoipCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AccemoipCheckUsername(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AccemoipCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AccemoipCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AccemoipCheckStorauth(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AccemoipInfo>> buildActionsOnPassedHook(DeciTreeOption<AccemoipInfo> option) {
		List<ActionStd<AccemoipInfo>> actions = new ArrayList<>();		

		ActionStd<AccemoipInfo> enforcePayPartner = new StdAccemoipEnforcePayPartner(option);	
		ActionLazy<AccemoipInfo> nodeUrl = new LazyAccemoipNodeUrl(option.conn, option.schemaName);
		
		enforcePayPartner.addPostAction(nodeUrl);
		
		actions.add(enforcePayPartner);		
		return actions;
	}
}
