package br.com.mind5.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovNodeMatock;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovRootSelect;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckInsert;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckLangu;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckMamovype;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckMat;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckMatarchProduct;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckMatore;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckOwner;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckStorauth;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckStore;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootMatmovInsert extends DeciTreeTemplateWriteV2<MatmovInfo> {
	
	public RootMatmovInsert(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatmovInfo> buildCheckerHook(DeciTreeOption<MatmovInfo> option) {
		List<ModelCheckerV1<MatmovInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatmovInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatmovCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmovCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmovCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmovCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmovCheckMat(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmovCheckMamovype(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmovCheckMatarchProduct(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmovCheckStorauth(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new MatmovCheckMatore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatmovInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovInfo> option) {
		List<ActionStdV1<MatmovInfo>> actions = new ArrayList<>();

		ActionStdV1<MatmovInfo> insert = new NodeMatmovInsert(option).toAction();
		ActionLazyV1<MatmovInfo> upsertStock = new LazyMatmovNodeMatock(option.conn, option.schemaName);
		ActionLazyV1<MatmovInfo> select = new LazyMatmovRootSelect(option.conn, option.schemaName);	
		
		insert.addPostAction(upsertStock);
		upsertStock.addPostAction(select);
		
		actions.add(insert);	
		return actions;
	}
}
