package br.com.gda.payment.storePartner.model.decsionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.model.action.LazyStoparMergeUsername;
import br.com.gda.payment.storePartner.model.action.LazyStoparNodeInsert;
import br.com.gda.payment.storePartner.model.action.LazyStoparRootSelect;
import br.com.gda.payment.storePartner.model.action.StdStoparEnforceLChanged;
import br.com.gda.payment.storePartner.model.checker.StoparCheckLangu;
import br.com.gda.payment.storePartner.model.checker.StoparCheckOwner;
import br.com.gda.payment.storePartner.model.checker.StoparCheckStore;
import br.com.gda.payment.storePartner.model.checker.StoparCheckWrite;

public final class RootStoparInsert extends DeciTreeWriteTemplate<StoparInfo> {
	
	public RootStoparInsert(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparInfo> buildDecisionCheckerHook(DeciTreeOption<StoparInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<StoparInfo>> queue = new ArrayList<>();		
		ModelChecker<StoparInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new StoparCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new StoparCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new StoparCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new StoparCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoparInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStd<StoparInfo>> actions = new ArrayList<>();		
		
		ActionStd<StoparInfo> enforceLChanged = new StdStoparEnforceLChanged(option);	
		ActionLazy<StoparInfo> enforceLChangedBy = new LazyStoparMergeUsername(option.conn, option.schemaName);
		ActionLazy<StoparInfo> insert = new LazyStoparNodeInsert(option.conn, option.schemaName);
		ActionLazy<StoparInfo> select = new LazyStoparRootSelect(option.conn, option.schemaName);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
