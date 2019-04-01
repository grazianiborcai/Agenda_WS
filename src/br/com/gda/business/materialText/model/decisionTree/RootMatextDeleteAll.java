package br.com.gda.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.model.action.LazyMatextDelete;
import br.com.gda.business.materialText.model.action.LazyMatextEnforceLChanged;
import br.com.gda.business.materialText.model.action.LazyMatextMergeToDelete;
import br.com.gda.business.materialText.model.action.LazyMatextMergeUsername;
import br.com.gda.business.materialText.model.action.LazyMatextUpdate;
import br.com.gda.business.materialText.model.action.StdMatextEnforceMatKey;
import br.com.gda.business.materialText.model.checker.MatextCheckDelete;
import br.com.gda.business.materialText.model.checker.MatextCheckHasItem;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatextDeleteAll extends DeciTreeWriteTemplate<MatextInfo> {

	public RootMatextDeleteAll(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextInfo> buildDecisionCheckerHook(DeciTreeOption<MatextInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checker = new MatextCheckDelete();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatextCheckHasItem(checkerOption);
		queue.add(checker);		

		return new ModelCheckerQueue<MatextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();

		ActionStd<MatextInfo> enforceMatKey = new StdMatextEnforceMatKey(option);
		ActionLazy<MatextInfo> mergeToDelete = new LazyMatextMergeToDelete(option.conn, option.schemaName);
		ActionLazy<MatextInfo> enforceLChanged = new LazyMatextEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<MatextInfo> enforceLChangedBy = new LazyMatextMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatextInfo> update = new LazyMatextUpdate(option.conn, option.schemaName);
		ActionLazy<MatextInfo> delete = new LazyMatextDelete(option.conn, option.schemaName);
		
		enforceMatKey.addPostAction(mergeToDelete);
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(enforceMatKey);
		return actions;
	}
}
