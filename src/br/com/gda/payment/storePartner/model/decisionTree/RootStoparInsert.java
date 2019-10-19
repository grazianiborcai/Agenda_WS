package br.com.gda.payment.storePartner.model.decisionTree;

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
import br.com.gda.payment.storePartner.model.action.LazyStoparNodeSnapshot;
import br.com.gda.payment.storePartner.model.action.LazyStoparRootSelect;
import br.com.gda.payment.storePartner.model.action.StdStoparEnforceLChanged;
import br.com.gda.payment.storePartner.model.checker.StoparCheckExist;
import br.com.gda.payment.storePartner.model.checker.StoparCheckLangu;
import br.com.gda.payment.storePartner.model.checker.StoparCheckOwner;
import br.com.gda.payment.storePartner.model.checker.StoparCheckPaypar;
import br.com.gda.payment.storePartner.model.checker.StoparCheckStorauth;
import br.com.gda.payment.storePartner.model.checker.StoparCheckStore;
import br.com.gda.payment.storePartner.model.checker.StoparCheckWrite;

public final class RootStoparInsert extends DeciTreeWriteTemplate<StoparInfo> {
	
	public RootStoparInsert(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparInfo> buildDecisionCheckerHook(DeciTreeOption<StoparInfo> option) {		
		List<ModelChecker<StoparInfo>> queue = new ArrayList<>();		
		ModelChecker<StoparInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoparCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoparCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoparCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoparCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoparCheckPaypar(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;	
		checker = new StoparCheckExist(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoparCheckStorauth(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoparInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStd<StoparInfo>> actions = new ArrayList<>();		
		//TODO: ID obrigatorio ?
		ActionStd<StoparInfo> enforceLChanged = new StdStoparEnforceLChanged(option);	
		ActionLazy<StoparInfo> enforceLChangedBy = new LazyStoparMergeUsername(option.conn, option.schemaName);
		ActionLazy<StoparInfo> insert = new LazyStoparNodeInsert(option.conn, option.schemaName);
		ActionLazy<StoparInfo> snapshot = new LazyStoparNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<StoparInfo> select = new LazyStoparRootSelect(option.conn, option.schemaName);		
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(insert);
		insert.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
