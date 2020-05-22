package br.com.mind5.business.materialStock.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.model.action.LazyMatockEnforceLChanged;
import br.com.mind5.business.materialStock.model.action.LazyMatockMergeToUpdate;
import br.com.mind5.business.materialStock.model.action.LazyMatockNodeBalanceL1;
import br.com.mind5.business.materialStock.model.action.LazyMatockUpdate;
import br.com.mind5.business.materialStock.model.action.StdMatockLock;
import br.com.mind5.business.materialStock.model.checker.MatockCheckExist;
import br.com.mind5.business.materialStock.model.checker.MatockCheckLangu;
import br.com.mind5.business.materialStock.model.checker.MatockCheckMat;
import br.com.mind5.business.materialStock.model.checker.MatockCheckMamovype;
import br.com.mind5.business.materialStock.model.checker.MatockCheckOwner;
import br.com.mind5.business.materialStock.model.checker.MatockCheckStorauth;
import br.com.mind5.business.materialStock.model.checker.MatockCheckStore;
import br.com.mind5.business.materialStock.model.checker.MatockCheckWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class RootMatockUpdate extends DeciTreeTemplateWriteV1<MatockInfo> {
	
	public RootMatockUpdate(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatockInfo> buildCheckerHook(DeciTreeOption<MatockInfo> option) {
		List<ModelCheckerV1<MatockInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatockInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatockCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatockCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatockCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatockCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatockCheckMat(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatockCheckMamovype(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatockCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatockCheckStorauth(checkerOption);
		queue.add(checker);	

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatockInfo>> buildActionsOnPassedHook(DeciTreeOption<MatockInfo> option) {
		List<ActionStdV1<MatockInfo>> actions = new ArrayList<>();

		ActionStdV1<MatockInfo> lockRecord = new StdMatockLock(option);
		ActionLazyV1<MatockInfo> mergeToUpdate = new LazyMatockMergeToUpdate(option.conn, option.schemaName);
		ActionLazyV1<MatockInfo> enforceLChanged = new LazyMatockEnforceLChanged(option.conn, option.schemaName);	
		ActionLazyV1<MatockInfo> balance = new LazyMatockNodeBalanceL1(option.conn, option.schemaName);	
		ActionLazyV1<MatockInfo> update = new LazyMatockUpdate(option.conn, option.schemaName);	
		
		lockRecord.addPostAction(mergeToUpdate);
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(balance);
		balance.addPostAction(update);
		
		actions.add(lockRecord);
		return actions;
	}
}
