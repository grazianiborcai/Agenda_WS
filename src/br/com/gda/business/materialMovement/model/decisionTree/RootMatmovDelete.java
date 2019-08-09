package br.com.gda.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.business.materialMovement.model.action.LazyMatmovDelete;
import br.com.gda.business.materialMovement.model.action.LazyMatmovEnforceLChanged;
import br.com.gda.business.materialMovement.model.action.LazyMatmovMergeUsername;
import br.com.gda.business.materialMovement.model.action.LazyMatmovUpdate;
import br.com.gda.business.materialMovement.model.action.StdMatmovMergeToDelete;
import br.com.gda.business.materialMovement.model.checker.MatmovCheckExist;
import br.com.gda.business.materialMovement.model.checker.MatmovCheckLangu;
import br.com.gda.business.materialMovement.model.checker.MatmovCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatmovDelete extends DeciTreeWriteTemplate<MatmovInfo> {
	
	public RootMatmovDelete(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatmovInfo> buildDecisionCheckerHook(DeciTreeOption<MatmovInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<MatmovInfo>> queue = new ArrayList<>();		
		ModelChecker<MatmovInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new MatmovCheckWrite();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatmovCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatmovCheckExist(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerQueue<MatmovInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatmovInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovInfo> option) {
		List<ActionStd<MatmovInfo>> actions = new ArrayList<>();
		
		ActionStd<MatmovInfo> mergeToDelete = new StdMatmovMergeToDelete(option);
		ActionLazy<MatmovInfo> enforceLChanged = new LazyMatmovEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<MatmovInfo> enforceLChangedBy = new LazyMatmovMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatmovInfo> update = new LazyMatmovUpdate(option.conn, option.schemaName);
		ActionLazy<MatmovInfo> delete = new LazyMatmovDelete(option.conn, option.schemaName);			
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);		
		return actions;
	}
}
