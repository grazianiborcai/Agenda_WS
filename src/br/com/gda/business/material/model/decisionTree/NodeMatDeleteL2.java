package br.com.gda.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.action.LazyMatDelete;
import br.com.gda.business.material.model.action.LazyMatEnforceLChanged;
import br.com.gda.business.material.model.action.LazyMatMergeUsername;
import br.com.gda.business.material.model.action.LazyMatUpdate;
import br.com.gda.business.material.model.action.StdMatDeleteMatext;
import br.com.gda.business.material.model.action.StdMatMergeToDelete;
import br.com.gda.business.material.model.checker.MatCheckDelete;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatDeleteL2 extends DeciTreeWriteTemplate<MatInfo> {
	
	public NodeMatDeleteL2(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildDecisionCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;
		
		checker = new MatCheckDelete();
		queue.add(checker);

		return new ModelCheckerQueue<MatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();
		
		ActionStd<MatInfo> deleteMatext = new StdMatDeleteMatext(option);
		ActionStd<MatInfo> mergeToDelete = new StdMatMergeToDelete(option);
		ActionLazy<MatInfo> enforceLChanged = new LazyMatEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<MatInfo> enforceLChangedBy = new LazyMatMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatInfo> updateAttr = new LazyMatUpdate(option.conn, option.schemaName);
		ActionLazy<MatInfo> delete = new LazyMatDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateAttr);
		updateAttr.addPostAction(delete);
		
		actions.add(deleteMatext);
		actions.add(mergeToDelete);
		return actions;
	}
}
