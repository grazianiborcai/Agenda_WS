package br.com.mind5.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovEnforcePostingDate;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovMergeMat;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovMergeUsername;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovNodeInsert;
import br.com.mind5.business.materialMovement.model.action.StdMatmovEnforceLChanged;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckInsert;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckLangu;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckMat;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckMatmovType;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckMatore;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckOwner;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckStorauth;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatmovInsert extends DeciTreeWriteTemplate<MatmovInfo> {
	
	public RootMatmovInsert(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatmovInfo> buildDecisionCheckerHook(DeciTreeOption<MatmovInfo> option) {
		List<ModelChecker<MatmovInfo>> queue = new ArrayList<>();		
		ModelChecker<MatmovInfo> checker;
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
		checker = new MatmovCheckMatmovType(checkerOption);
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
		
		//TODO: posting date + recordmode
		//TODO: lock table for update
		//TODO: check limit
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatmovInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovInfo> option) {
		List<ActionStd<MatmovInfo>> actions = new ArrayList<>();

		ActionStd<MatmovInfo> enforceLChanged = new StdMatmovEnforceLChanged(option);
		ActionLazy<MatmovInfo> enforceLChangedBy = new LazyMatmovMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatmovInfo> mergeMat = new LazyMatmovMergeMat(option.conn, option.schemaName);
		ActionLazy<MatmovInfo> enforcePostingDate = new LazyMatmovEnforcePostingDate(option.conn, option.schemaName);
		ActionLazy<MatmovInfo> nodeInsert = new LazyMatmovNodeInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(mergeMat);		
		mergeMat.addPostAction(enforcePostingDate);
		enforcePostingDate.addPostAction(nodeInsert);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
