package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatNodeSnapshot;
import br.com.mind5.business.material.model.action.LazyMatNodeUpsertMatext;
import br.com.mind5.business.material.model.action.LazyMatRootSelect;
import br.com.mind5.business.material.model.checker.MatCheckMateg;
import br.com.mind5.business.material.model.checker.MatCheckMatoup;
import br.com.mind5.business.material.model.checker.MatCheckInsert;
import br.com.mind5.business.material.model.checker.MatCheckLangu;
import br.com.mind5.business.material.model.checker.MatCheckOwner;
import br.com.mind5.business.material.model.checker.MatCheckMatype;
import br.com.mind5.business.material.model.checker.MatCheckMatunit;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootMatInsert extends DeciTreeTemplateWriteV2<MatInfo> {
	
	public RootMatInsert(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelCheckerV1<MatInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckMatunit(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckMateg(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckMatoup(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckMatype(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStdV1<MatInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<MatInfo> insertMat = new NodeMatInsert(option).toAction();	
		ActionLazyV1<MatInfo> upsertMatext = new LazyMatNodeUpsertMatext(option.conn, option.schemaName);	
		ActionLazyV1<MatInfo> snapshot = new LazyMatNodeSnapshot(option.conn, option.schemaName);
		ActionLazyV1<MatInfo> select = new LazyMatRootSelect(option.conn, option.schemaName);		
		
		insertMat.addPostAction(upsertMatext);
		upsertMatext.addPostAction(snapshot);	
		snapshot.addPostAction(select);
		
		actions.add(insertMat);		
		return actions;
	}
}
