package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.LazyMatextDaoDelete;
import br.com.mind5.business.materialText.model.action.LazyMatextDaoUpdate;
import br.com.mind5.business.materialText.model.action.LazyMatextMergeUsername;
import br.com.mind5.business.materialText.model.action.StdMatextEnforceLChanged;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeMatextDeleteL1 extends DeciTreeTemplateWrite<MatextInfo> {

	public NodeMatextDeleteL1(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextInfo> buildCheckerHook(DeciTreeOption<MatextInfo> option) {
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;
			
		checker = new ModelCheckerDummy<>();
		queue.add(checker);

		return new ModelCheckerHelperQueue<MatextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();
		
		ActionStd<MatextInfo> enforceLChanged = new StdMatextEnforceLChanged(option);
		ActionLazy<MatextInfo> enforceLChangedBy = new LazyMatextMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatextInfo> update = new LazyMatextDaoUpdate(option.conn, option.schemaName);
		ActionLazy<MatextInfo> delete = new LazyMatextDaoDelete(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
