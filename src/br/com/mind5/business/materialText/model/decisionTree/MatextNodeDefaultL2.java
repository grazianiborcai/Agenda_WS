package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.MatextVisiDaoUpdate;
import br.com.mind5.business.materialText.model.action.MatextVisiEnforceDefaultOff;
import br.com.mind5.business.materialText.model.action.MatextVisiEnforceLChanged;
import br.com.mind5.business.materialText.model.action.MatextVisiMergeMatextault;
import br.com.mind5.business.materialText.model.action.MatextVisiMergeToSelect;
import br.com.mind5.business.materialText.model.action.MatextVisiMergeUsername;
import br.com.mind5.business.materialText.model.checker.MatextCheckMatextault;
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

public final class MatextNodeDefaultL2 extends DeciTreeTemplateWrite<MatextInfo> {
	
	public MatextNodeDefaultL2(DeciTreeOption<MatextInfo> option) {
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
		checker = new MatextCheckMatextault(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();
		
		ActionStd<MatextInfo> mergeMatextault = new ActionStdCommom<MatextInfo>(option, MatextVisiMergeMatextault.class);
		ActionLazy<MatextInfo> mergeToSelect = new ActionLazyCommom<MatextInfo>(option, MatextVisiMergeToSelect.class);
		ActionLazy<MatextInfo> enforceLChanged = new ActionLazyCommom<MatextInfo>(option, MatextVisiEnforceLChanged.class);	
		ActionLazy<MatextInfo> enforceLChangedBy = new ActionLazyCommom<MatextInfo>(option, MatextVisiMergeUsername.class);
		ActionLazy<MatextInfo> enforceDefaultOff = new ActionLazyCommom<MatextInfo>(option, MatextVisiEnforceDefaultOff.class);
		ActionLazy<MatextInfo> update = new ActionLazyCommom<MatextInfo>(option, MatextVisiDaoUpdate.class);
		ActionStd<MatextInfo> success = new ActionStdSuccessCommom<MatextInfo>(option);	
		
		mergeMatextault.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceDefaultOff);
		enforceDefaultOff.addPostAction(update);
		
		actions.add(mergeMatextault);
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnFailedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();

		ActionStd<MatextInfo> success = new ActionStdSuccessCommom<MatextInfo>(option);		
		actions.add(success);
		
		return actions;
	}
}
