package br.com.gda.payment.accessMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.accessMoip.info.AccemoipInfo;
import br.com.gda.payment.accessMoip.model.action.LazyAccemoipNodeUrl;
import br.com.gda.payment.accessMoip.model.action.StdAccemoipEnforcePayPartner;
import br.com.gda.payment.accessMoip.model.checker.AccemoipCheckLangu;
import br.com.gda.payment.accessMoip.model.checker.AccemoipCheckOwner;
import br.com.gda.payment.accessMoip.model.checker.AccemoipCheckStorauth;
import br.com.gda.payment.accessMoip.model.checker.AccemoipCheckStore;
import br.com.gda.payment.accessMoip.model.checker.AccemoipCheckUsername;
import br.com.gda.payment.accessMoip.model.checker.AccemoipCheckWrite;

public final class RootAccemoipUrl extends DeciTreeWriteTemplate<AccemoipInfo> {
	
	public RootAccemoipUrl(DeciTreeOption<AccemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AccemoipInfo> buildDecisionCheckerHook(DeciTreeOption<AccemoipInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<AccemoipInfo>> queue = new ArrayList<>();		
		ModelChecker<AccemoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new AccemoipCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new AccemoipCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new AccemoipCheckUsername(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new AccemoipCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new AccemoipCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new AccemoipCheckStorauth(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
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
