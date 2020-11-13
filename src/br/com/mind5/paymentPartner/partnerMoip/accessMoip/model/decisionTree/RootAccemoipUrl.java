package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.LazyAccemoipNodeUrl;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action.StdAccemoipEnforcePayPartner;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckLangu;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckOwner;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckStorauth;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckStore;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckUsername;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.checker.AccemoipCheckWrite;

public final class RootAccemoipUrl extends DeciTreeTemplateWriteV2<AccemoipInfo> {
	
	public RootAccemoipUrl(DeciTreeOption<AccemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<AccemoipInfo> buildCheckerHook(DeciTreeOption<AccemoipInfo> option) {
		List<ModelCheckerV1<AccemoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<AccemoipInfo> checker;	
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

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AccemoipInfo>> buildActionsOnPassedHook(DeciTreeOption<AccemoipInfo> option) {
		List<ActionStdV1<AccemoipInfo>> actions = new ArrayList<>();		

		ActionStdV1<AccemoipInfo> enforcePayPartner = new StdAccemoipEnforcePayPartner(option);	
		ActionLazy<AccemoipInfo> nodeUrl = new LazyAccemoipNodeUrl(option.conn, option.schemaName);
		
		enforcePayPartner.addPostAction(nodeUrl);
		
		actions.add(enforcePayPartner);		
		return actions;
	}
}
