package br.com.mind5.masterData.materialGroupOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiDaoUpdate;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiEnforceLChanged;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiMergeUsername;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiNodeRgbL1;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatoupowNodeUpdate extends DeciTreeTemplateWrite<MatoupowInfo> {
	
	public MatoupowNodeUpdate(DeciTreeOption<MatoupowInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoupowInfo> buildCheckerHook(DeciTreeOption<MatoupowInfo> option) {
		List<ModelChecker<MatoupowInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoupowInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoupowInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoupowInfo> option) {
		List<ActionStd<MatoupowInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatoupowInfo> enforceLChanged 	= new ActionStdCommom<MatoupowInfo>(option, MatoupowVisiEnforceLChanged.class);
		ActionLazy<MatoupowInfo> enforceLChangedBy 	= new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiMergeUsername.class);
		ActionLazy<MatoupowInfo> nodeRgb 			= new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiNodeRgbL1.class);
		ActionLazy<MatoupowInfo> update 			= new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiDaoUpdate.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);	
		enforceLChangedBy.addPostAction(nodeRgb);
		nodeRgb.addPostAction(update);
		
		actions.add(enforceLChanged);		
		return actions;
	}
}
