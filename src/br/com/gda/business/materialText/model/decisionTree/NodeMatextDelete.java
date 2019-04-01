package br.com.gda.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.model.action.LazyMatextDelete;
import br.com.gda.business.materialText.model.action.LazyMatextMergeUsername;
import br.com.gda.business.materialText.model.action.LazyMatextUpdate;
import br.com.gda.business.materialText.model.action.StdMatextEnforceLChanged;
import br.com.gda.business.materialText.model.checker.MatextCheckDeleteDefault;
import br.com.gda.business.materialText.model.checker.MatextCheckExist;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatextDelete extends DeciTreeWriteTemplate<MatextInfo> {

	public NodeMatextDelete(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextInfo> buildDecisionCheckerHook(DeciTreeOption<MatextInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checker = new MatextCheckDeleteDefault();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatextCheckExist(checkerOption);
		queue.add(checker);		

		return new ModelCheckerQueue<MatextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();
		
		ActionStd<MatextInfo> enforceLChanged = new StdMatextEnforceLChanged(option);
		ActionLazy<MatextInfo> enforceLChangedBy = new LazyMatextMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatextInfo> update = new LazyMatextUpdate(option.conn, option.schemaName);
		ActionLazy<MatextInfo> delete = new LazyMatextDelete(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
