package br.com.mind5.payment.storePartnerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.mind5.payment.storePartnerSnapshot.model.action.LazyStoparnapRootSelect;
import br.com.mind5.payment.storePartnerSnapshot.model.action.StdStoparnapDaoInsert;
import br.com.mind5.payment.storePartnerSnapshot.model.checker.StoparnapCheckLangu;
import br.com.mind5.payment.storePartnerSnapshot.model.checker.StoparnapCheckOwner;
import br.com.mind5.payment.storePartnerSnapshot.model.checker.StoparnapCheckWrite;

public final class RootStoparnapInsert extends DeciTreeTemplateWrite<StoparnapInfo> {
	
	public RootStoparnapInsert(DeciTreeOption<StoparnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparnapInfo> buildCheckerHook(DeciTreeOption<StoparnapInfo> option) {
		List<ModelChecker<StoparnapInfo>> queue = new ArrayList<>();		
		ModelChecker<StoparnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoparnapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoparnapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoparnapCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoparnapInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparnapInfo> option) {
		List<ActionStd<StoparnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<StoparnapInfo> insert = new StdStoparnapDaoInsert(option);	
		ActionLazy<StoparnapInfo> select = new LazyStoparnapRootSelect(option.conn, option.schemaName);	
		
		insert.addPostAction(select);
		
		actions.add(insert);		
		return actions;
	}
}
