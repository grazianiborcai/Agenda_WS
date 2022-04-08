package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.MatextVisiDaoDelete;
import br.com.mind5.business.materialText.model.action.MatextVisiDaoUpdate;
import br.com.mind5.business.materialText.model.action.MatextVisiEnforceLChanged;
import br.com.mind5.business.materialText.model.action.MatextVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatextNodeDeleteL1 extends DeciTreeTemplateWrite<MatextInfo> {

	public MatextNodeDeleteL1(DeciTreeOption<MatextInfo> option) {
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
		
		ActionStd<MatextInfo> enforceLChanged = new ActionStdCommom<MatextInfo>(option, MatextVisiEnforceLChanged.class);
		ActionLazy<MatextInfo> enforceLChangedBy = new ActionLazyCommom<MatextInfo>(option, MatextVisiMergeUsername.class);
		ActionLazy<MatextInfo> update = new ActionLazyCommom<MatextInfo>(option, MatextVisiDaoUpdate.class);
		ActionLazy<MatextInfo> delete = new ActionLazyCommom<MatextInfo>(option, MatextVisiDaoDelete.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
