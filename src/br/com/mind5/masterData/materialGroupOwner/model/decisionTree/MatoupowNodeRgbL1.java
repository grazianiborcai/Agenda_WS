package br.com.mind5.masterData.materialGroupOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiEnforceRgbHexHashtag;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiEnforceRgbHexUpper;
import br.com.mind5.masterData.materialGroupOwner.model.action.MatoupowVisiNodeRgbL2;
import br.com.mind5.masterData.materialGroupOwner.model.checker.MatoupowCheckHasRbgHex;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatoupowNodeRgbL1 extends DeciTreeTemplateWrite<MatoupowInfo> {
	
	public MatoupowNodeRgbL1(DeciTreeOption<MatoupowInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoupowInfo> buildCheckerHook(DeciTreeOption<MatoupowInfo> option) {
		List<ModelChecker<MatoupowInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoupowInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new MatoupowCheckHasRbgHex(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoupowInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoupowInfo> option) {
		List<ActionStd<MatoupowInfo>> actions = new ArrayList<>();

		ActionStd<MatoupowInfo> enforceRgbHexHashtag 	= new ActionStdCommom<MatoupowInfo>(option, MatoupowVisiEnforceRgbHexHashtag.class);
		ActionLazy<MatoupowInfo> enforceRgbHexUpper 	= new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiEnforceRgbHexUpper.class);
		ActionLazy<MatoupowInfo> nodeL2 				= new ActionLazyCommom<MatoupowInfo>(option, MatoupowVisiNodeRgbL2.class);
		
		enforceRgbHexHashtag.addPostAction(enforceRgbHexUpper);
		enforceRgbHexUpper.addPostAction(nodeL2);
		
		actions.add(enforceRgbHexHashtag);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatoupowInfo>> buildActionsOnFailedHook(DeciTreeOption<MatoupowInfo> option) {
		List<ActionStd<MatoupowInfo>> actions = new ArrayList<>();

		ActionStd<MatoupowInfo> nodeL3 = new MatoupowNodeRgbL3(option).toAction();
		
		actions.add(nodeL3);
		return actions;
	}
}
