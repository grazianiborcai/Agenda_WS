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
import br.com.mind5.payment.storePartner.model.action.LazyStoparDaoDelete;
import br.com.mind5.payment.storePartner.model.action.LazyStoparEnforceLChanged;
import br.com.mind5.payment.storePartner.model.action.LazyStoparMergeUsername;
import br.com.mind5.payment.storePartner.model.action.LazyStoparDaoUpdate;
import br.com.mind5.payment.storePartner.model.action.StdStoparMergeToDelete;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckExist;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckLangu;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckOwner;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckStorauth;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckWrite;

public final class RootStoparDelete extends DeciTreeTemplateWrite<StoparInfo> {
	
	public RootStoparDelete(DeciTreeOption<StoparInfo> option) {
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
		//TODO: nao pode elimnar se for Owner-Default
		ActionStd<StoparInfo> mergeToDelete = new StdStoparMergeToDelete(option);
		ActionLazy<StoparInfo> enforceLChanged = new LazyStoparEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<StoparInfo> enforceLChangedBy = new LazyStoparMergeUsername(option.conn, option.schemaName);
		ActionLazy<StoparInfo> update = new LazyStoparDaoUpdate(option.conn, option.schemaName);
		ActionLazy<StoparInfo> delete = new LazyStoparDaoDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);
		return actions;		
	}
}
