package br.com.mind5.payment.storePartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.action.LazyStoparMergeUsername;
import br.com.mind5.payment.storePartner.model.action.LazyStoparNodeSnapshot;
import br.com.mind5.payment.storePartner.model.action.LazyStoparRootSelect;
import br.com.mind5.payment.storePartner.model.action.LazyStoparDaoUpdate;
import br.com.mind5.payment.storePartner.model.action.StdStoparEnforceLChanged;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckExist;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckLangu;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckOwner;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckPaypar;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckStorauth;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckStore;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckWrite;

public final class RootStoparUpdate extends DeciTreeTemplateWrite<StoparInfo> {
	
	public RootStoparUpdate(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparInfo> buildCheckerHook(DeciTreeOption<StoparInfo> option) {
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
		checker = new StoparCheckLangu(checkerOption);
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
		checker = new StoparCheckStore(checkerOption);
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
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoparCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoparCheckStorauth(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<StoparInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoparInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStd<StoparInfo>> actions = new ArrayList<>();
		//TODO: ID obrigatorio ?		
		ActionStd<StoparInfo> enforceLChanged = new StdStoparEnforceLChanged(option);
		ActionLazy<StoparInfo> enforceLChangedBy = new LazyStoparMergeUsername(option.conn, option.schemaName);
		ActionLazy<StoparInfo> update = new LazyStoparDaoUpdate(option.conn, option.schemaName);
		ActionLazy<StoparInfo> snapshot = new LazyStoparNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<StoparInfo> select = new LazyStoparRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;		
	}
}
