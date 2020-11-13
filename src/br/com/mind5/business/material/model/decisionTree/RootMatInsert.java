package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatNodeSnapshot;
import br.com.mind5.business.material.model.action.LazyMatNodeUpsertMatext;
import br.com.mind5.business.material.model.action.LazyMatRootSelect;
import br.com.mind5.business.material.model.checker.MatCheckInsert;
import br.com.mind5.business.material.model.checker.MatCheckLangu;
import br.com.mind5.business.material.model.checker.MatCheckMateg;
import br.com.mind5.business.material.model.checker.MatCheckMatoup;
import br.com.mind5.business.material.model.checker.MatCheckMatubup;
import br.com.mind5.business.material.model.checker.MatCheckMatunit;
import br.com.mind5.business.material.model.checker.MatCheckMatype;
import br.com.mind5.business.material.model.checker.MatCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootMatInsert extends DeciTreeTemplateWrite<MatInfo> {
	
	public RootMatInsert(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;
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
		checker = new MatCheckMatubup(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatCheckMatype(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatInfo> insertMat = new NodeMatInsert(option).toAction();	
		ActionLazy<MatInfo> upsertMatext = new LazyMatNodeUpsertMatext(option.conn, option.schemaName);	
		ActionLazy<MatInfo> snapshot = new LazyMatNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<MatInfo> select = new LazyMatRootSelect(option.conn, option.schemaName);		
		
		insertMat.addPostAction(upsertMatext);
		upsertMatext.addPostAction(snapshot);	
		snapshot.addPostAction(select);
		
		actions.add(insertMat);		
		return actions;
	}
}
