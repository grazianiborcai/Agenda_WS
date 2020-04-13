package br.com.mind5.payment.storePartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.action.LazyStoparDelete;
import br.com.mind5.payment.storePartner.model.action.LazyStoparEnforceLChanged;
import br.com.mind5.payment.storePartner.model.action.LazyStoparMergeUsername;
import br.com.mind5.payment.storePartner.model.action.LazyStoparUpdate;
import br.com.mind5.payment.storePartner.model.action.StdStoparMergeToDelete;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckExist;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckLangu;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckOwner;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckStorauth;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckWrite;

public final class RootStoparDelete extends DeciTreeTemplateWriteV1<StoparInfo> {
	
	public RootStoparDelete(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoparInfo> buildCheckerHook(DeciTreeOption<StoparInfo> option) {
		List<ModelCheckerV1<StoparInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoparInfo> checker;
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
		
		return new ModelCheckerHelperQueueV2<StoparInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoparInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStdV1<StoparInfo>> actions = new ArrayList<>();
		//TODO: nao pode elimnar se for Owner-Default
		ActionStdV1<StoparInfo> mergeToDelete = new StdStoparMergeToDelete(option);
		ActionLazyV1<StoparInfo> enforceLChanged = new LazyStoparEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<StoparInfo> enforceLChangedBy = new LazyStoparMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<StoparInfo> update = new LazyStoparUpdate(option.conn, option.schemaName);
		ActionLazyV1<StoparInfo> delete = new LazyStoparDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);
		return actions;		
	}
}
