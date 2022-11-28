package br.com.mind5.masterData.materialGroupOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiEnforceRgbWhite;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiRootInsert;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatoupowRootInsertWhite extends DeciTreeTemplateWrite<MatoupowInfo> {
	
	public MatoupowRootInsertWhite(DeciTreeOption<MatoupowInfo> option) {
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
		
		ActionStd<MatoupowInfo> enforceRgbWhite = new ActionStdCommom<MatoupowInfo>(option, MatoupowVisiEnforceRgbWhite.class);
		ActionLazy<MatoupowInfo> insert 		= new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiRootInsert.class);
		
		enforceRgbWhite.addPostAction(insert);
		
		actions.add(enforceRgbWhite);		
		return actions;
	}
}
