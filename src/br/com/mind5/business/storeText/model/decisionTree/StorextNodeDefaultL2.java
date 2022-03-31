package br.com.mind5.business.storeText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.action.StorextVisiDaoUpdate;
import br.com.mind5.business.storeText.model.action.StorextVisiEnforceDefaultOff;
import br.com.mind5.business.storeText.model.action.StorextVisiEnforceLChanged;
import br.com.mind5.business.storeText.model.action.StorextVisiMergeStorextault;
import br.com.mind5.business.storeText.model.action.StorextVisiMergeToSelect;
import br.com.mind5.business.storeText.model.action.StorextVisiMergeUsername;
import br.com.mind5.business.storeText.model.checker.StorextCheckStorextault;
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

public final class StorextNodeDefaultL2 extends DeciTreeTemplateWrite<StorextInfo> {
	
	public StorextNodeDefaultL2(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorextInfo> buildCheckerHook(DeciTreeOption<StorextInfo> option) {
		List<ModelChecker<StorextInfo>> queue = new ArrayList<>();		
		ModelChecker<StorextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StorextCheckStorextault(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorextInfo>> buildActionsOnPassedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStd<StorextInfo>> actions = new ArrayList<>();
		
		ActionStd<StorextInfo> mergeStorextault = new ActionStdCommom<StorextInfo>(option, StorextVisiMergeStorextault.class);
		ActionLazy<StorextInfo> mergeToSelect = new ActionLazyCommom<StorextInfo>(option, StorextVisiMergeToSelect.class);
		ActionLazy<StorextInfo> enforceLChanged = new ActionLazyCommom<StorextInfo>(option, StorextVisiEnforceLChanged.class);	
		ActionLazy<StorextInfo> enforceLChangedBy = new ActionLazyCommom<StorextInfo>(option, StorextVisiMergeUsername.class);
		ActionLazy<StorextInfo> enforceDefaultOff = new ActionLazyCommom<StorextInfo>(option, StorextVisiEnforceDefaultOff.class);
		ActionLazy<StorextInfo> update = new ActionLazyCommom<StorextInfo>(option, StorextVisiDaoUpdate.class);
		ActionStd<StorextInfo> success = new ActionStdSuccessCommom<StorextInfo>(option);	
		
		mergeStorextault.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceDefaultOff);
		enforceDefaultOff.addPostAction(update);
		
		actions.add(mergeStorextault);
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorextInfo>> buildActionsOnFailedHook(DeciTreeOption<StorextInfo> option) {
		List<ActionStd<StorextInfo>> actions = new ArrayList<>();

		ActionStd<StorextInfo> success = new ActionStdSuccessCommom<StorextInfo>(option);		
		actions.add(success);
		
		return actions;
	}
}
