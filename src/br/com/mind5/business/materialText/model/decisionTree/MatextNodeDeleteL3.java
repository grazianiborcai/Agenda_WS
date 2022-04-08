package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.MatextVisiRootUpdate;
import br.com.mind5.business.materialText.model.action.MatextVisiEnforceDefaultOn;
import br.com.mind5.business.materialText.model.action.MatextVisiMergeMatextarch;
import br.com.mind5.business.materialText.model.action.MatextVisiMergeToSelect;
import br.com.mind5.business.materialText.model.checker.MatextCheckMatextarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class MatextNodeDeleteL3 extends DeciTreeTemplateWrite<MatextInfo> {

	public MatextNodeDeleteL3(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextInfo> buildCheckerHook(DeciTreeOption<MatextInfo> option) {
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;
		ModelCheckerOption checkerOption;
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new MatextCheckMatextarch(checkerOption);
		queue.add(checker);		

		return new ModelCheckerHelperQueue<MatextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();
		
		ActionStd<MatextInfo> mergeMatextarch = new ActionStdCommom<MatextInfo>(option, MatextVisiMergeMatextarch.class);
		ActionLazy<MatextInfo> mergeToSelect = new ActionLazyCommom<MatextInfo>(option, MatextVisiMergeToSelect.class);
		ActionLazy<MatextInfo> enforceDefaultOn = new ActionLazyCommom<MatextInfo>(option, MatextVisiEnforceDefaultOn.class); 
		ActionLazy<MatextInfo> update = new ActionLazyCommom<MatextInfo>(option, MatextVisiRootUpdate.class); 
		
		mergeMatextarch.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(enforceDefaultOn);
		enforceDefaultOn.addPostAction(update);
		
		actions.add(mergeMatextarch);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnFailedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();
		
		ActionStd<MatextInfo> success = new ActionStdSuccessCommom<MatextInfo>(option);
		
		actions.add(success);
		return actions;
	}
}
