package br.com.gda.payment.storePartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.model.action.LazyStoparDelete;
import br.com.gda.payment.storePartner.model.action.LazyStoparEnforceLChanged;
import br.com.gda.payment.storePartner.model.action.LazyStoparMergeUsername;
import br.com.gda.payment.storePartner.model.action.LazyStoparUpdate;
import br.com.gda.payment.storePartner.model.action.StdStoparMergeToDelete;
import br.com.gda.payment.storePartner.model.checker.StoparCheckExist;
import br.com.gda.payment.storePartner.model.checker.StoparCheckLangu;
import br.com.gda.payment.storePartner.model.checker.StoparCheckStorauth;
import br.com.gda.payment.storePartner.model.checker.StoparCheckWrite;

public final class RootStoparDelete extends DeciTreeWriteTemplate<StoparInfo> {
	
	public RootStoparDelete(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparInfo> buildDecisionCheckerHook(DeciTreeOption<StoparInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<StoparInfo>> queue = new ArrayList<>();		
		ModelChecker<StoparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();	
		checker = new StoparCheckWrite();
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
		checker = new StoparCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoparCheckStorauth(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<StoparInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoparInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStd<StoparInfo>> actions = new ArrayList<>();
		//TODO: nao pode elimnar se for Owner-Default
		ActionStd<StoparInfo> mergeToDelete = new StdStoparMergeToDelete(option);
		ActionLazy<StoparInfo> enforceLChanged = new LazyStoparEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<StoparInfo> enforceLChangedBy = new LazyStoparMergeUsername(option.conn, option.schemaName);
		ActionLazy<StoparInfo> update = new LazyStoparUpdate(option.conn, option.schemaName);
		ActionLazy<StoparInfo> delete = new LazyStoparDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);
		return actions;		
	}
}
